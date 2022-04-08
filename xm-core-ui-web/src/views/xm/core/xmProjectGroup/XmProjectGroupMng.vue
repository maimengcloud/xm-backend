<template>
	<section class="page-container border padding">
		<el-row>
			<el-input v-model="filters.key" style="width: 20%;" placeholder="模糊查询"></el-input>
			<el-button v-loading="load.list" :disabled="load.list==true" @click="searchXmProjectGroups" icon="el-icon-search">查询</el-button>
			<el-button type="primary" @click="showAdd" icon="el-icon-plus"> </el-button>
			<el-button type="danger" v-loading="load.del" @click="batchDel" :disabled="this.sels.length===0 || load.del==true" icon="el-icon-delete"></el-button>
		</el-row>
		<el-row class="padding-top">
			<!--列表 XmProjectGroup xm_project_group-->
			<el-table ref="xmProjectGroupTable" :data="xmProjectGroups" :height="maxTableHeight" @sort-change="sortChange" highlight-current-row v-loading="load.list" border @selection-change="selsChange" @row-click="rowClick" style="width: 100%;">
				<el-table-column  type="selection" width="55" show-overflow-tooltip></el-table-column>
				<el-table-column sortable type="index" width="55" show-overflow-tooltip></el-table-column>
				<el-table-column prop="id" label="主键" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="groupName" label="团队名称" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="projectId" label="项目编号-属于产品线则可为空" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="pgTypeId" label="项目团队类型编号" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="pgTypeName" label="团队类型名称" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="leaderUserid" label="团队负责人" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="leaderUsername" label="负责人姓名" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="ctime" label="创建时间" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="ltime" label="更新时间" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="productId" label="产品编号，属于项目组的团队则可为空" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="branchId" label="机构编号" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="pgClass" label="团队类别0项目1产品" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="pgroupId" label="上级团队编号" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="lvl" label="级别0级1级2级3级4级" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="pidPaths" label="上级编号路径逗号分割,0,开始，本组编号+逗号结束" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="isTpl" label="是否为模板" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="assUserid" label="副组长编号" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="assUsername" label="副组长姓名" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="childrenCnt" label="下级团队数量" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="userCnt" label="组员数量" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="qxCode" label="权限码" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="calcWorkload" label="是否计算工作量0否1是" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column prop="ntype" label="节点类型0管理团队、1执行团队" min-width="80" show-overflow-tooltip></el-table-column>
				<el-table-column label="操作" width="180" fixed="right">
				    <template slot="header">
                        <el-button @click="showAdd" icon="el-icon-plus" circle> </el-button>
                    </template>
					<template scope="scope">
						<el-button type="primary" @click="showEdit( scope.row,scope.$index)" icon="el-icon-edit"></el-button>
						<el-button type="danger" @click="handleDel(scope.row,scope.$index)" icon="el-icon-delete"></el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination  layout="total, sizes, prev, pager, next" @current-change="handleCurrentChange" @size-change="handleSizeChange" :page-sizes="[10,20, 50, 100, 500]" :current-page="pageInfo.pageNum" :page-size="pageInfo.pageSize"  :total="pageInfo.total" style="float:right;"></el-pagination>
		</el-row>
		<el-row>
			<!--编辑 XmProjectGroup xm_project_group界面-->
			<el-drawer title="编辑xm_project_group" :visible.sync="editFormVisible"  size="60%"  append-to-body   :close-on-click-modal="false">
				  <xm-project-group-edit op-type="edit" :xm-project-group="editForm" :visible="editFormVisible" @cancel="editFormVisible=false" @submit="afterEditSubmit"></xm-project-group-edit>
			</el-drawer>

			<!--新增 XmProjectGroup xm_project_group界面-->
			<el-drawer title="新增xm_project_group" :visible.sync="addFormVisible"  size="60%"  append-to-body  :close-on-click-modal="false">
				<xm-project-group-edit op-type="add" :visible="addFormVisible" @cancel="addFormVisible=false" @submit="afterAddSubmit"></xm-project-group-edit>
			</el-drawer>
	    </el-row>
	</section>
</template>

<script>
	import util from '@/common/js/util';//全局公共库
	import config from '@/common/config';//全局公共库 
	import { getDicts,initSimpleDicts,initComplexDicts } from '@/api/mdp/meta/item';//字典表
	import { listXmProjectGroup, delXmProjectGroup, batchDelXmProjectGroup } from '@/api/xm/core/xmProjectGroup';
	import  XmProjectGroupEdit from './XmProjectGroupEdit';//新增修改界面
	import { mapGetters } from 'vuex'
	
	export default {
	    name:'xmProjectGroupMng',
		components: {
		    XmProjectGroupEdit,
		},
		props:['visible'],
		computed: {
		    ...mapGetters(['userInfo']),

		},
		watch:{
            visible(val){
                if(val==true){
                    this.initData();
                    this.searchXmProjectGroups()
                }
            }
		},
		data() {
			return {
				filters: {
					key: ''
				},
				xmProjectGroups: [],//查询结果
				pageInfo:{//分页数据
					total:0,//服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算。
					pageSize:10,//每页数据
					count:false,//是否需要重新计算总记录数
					pageNum:1,//当前页码、从1开始计算
					orderFields:[],//排序列 如 ['sex','student_id']，必须为数据库字段
					orderDirs:[]//升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']
				},
				load:{ list: false, edit: false, del: false, add: false },//查询中...
				sels: [],//列表选中数据
				dicts:{
				    //sex: [{id:'1',name:'男'},{id:'2',name:'女'}]
				},//下拉选择框的所有静态数据 params={categoryId:'all',itemCodes:['sex']} 返回结果 {sex: [{id:'1',name:'男'},{id:'2',name:'女'}]}
				addFormVisible: false,//新增xmProjectGroup界面是否显示
				addForm: {
					id:'',groupName:'',projectId:'',pgTypeId:'',pgTypeName:'',leaderUserid:'',leaderUsername:'',ctime:'',ltime:'',productId:'',branchId:'',pgClass:'',pgroupId:'',lvl:'',pidPaths:'',isTpl:'',assUserid:'',assUsername:'',childrenCnt:'',userCnt:'',qxCode:'',calcWorkload:'',ntype:''
				},
				
				editFormVisible: false,//编辑界面是否显示
				editForm: {
					id:'',groupName:'',projectId:'',pgTypeId:'',pgTypeName:'',leaderUserid:'',leaderUsername:'',ctime:'',ltime:'',productId:'',branchId:'',pgClass:'',pgroupId:'',lvl:'',pidPaths:'',isTpl:'',assUserid:'',assUsername:'',childrenCnt:'',userCnt:'',qxCode:'',calcWorkload:'',ntype:''
				},
				maxTableHeight:300,
			}
		},//end data
		methods: { 
			handleSizeChange(pageSize) { 
				this.pageInfo.pageSize=pageSize; 
				this.getXmProjectGroups();
			},
			handleCurrentChange(pageNum) {
				this.pageInfo.pageNum = pageNum;
				this.getXmProjectGroups();
			},
			// 表格排序 obj.order=ascending/descending,需转化为 asc/desc ; obj.prop=表格中的排序字段,字段驼峰命名
			sortChange( obj ){
				if(obj.order==null){
					this.pageInfo.orderFields=[];
					this.pageInfo.orderDirs=[]; 
				}else{
					var dir='asc';
					if(obj.order=='ascending'){
						dir='asc'
					}else{
						dir='desc';
					}
					 
					this.pageInfo.orderFields=[util.toLine(obj.prop)]; 
					this.pageInfo.orderDirs=[dir];
				}
				this.getXmProjectGroups();
			},
			searchXmProjectGroups(){
				 this.pageInfo.count=true; 
				 this.getXmProjectGroups();
			},
			//获取列表 XmProjectGroup xm_project_group
			getXmProjectGroups() {
				let params = {
					pageSize: this.pageInfo.pageSize,
					pageNum: this.pageInfo.pageNum,
					total: this.pageInfo.total,
					count:this.pageInfo.count
				};
				if(this.pageInfo.orderFields!=null && this.pageInfo.orderFields.length>0){
					let orderBys=[];
					for(var i=0;i<this.pageInfo.orderFields.length;i++){ 
						orderBys.push(this.pageInfo.orderFields[i]+" "+this.pageInfo.orderDirs[i])
					}  
					params.orderBy= orderBys.join(",")
				}
				if(this.filters.key){
					params.key=this.filters.key
				}

				this.load.list = true;
				listXmProjectGroup(params).then((res) => {
					var tips=res.data.tips;
					if(tips.isOk){ 
						this.pageInfo.total = res.data.total;
						this.pageInfo.count=false;
						this.xmProjectGroups = res.data.data;
					}else{
						this.$message({ showClose:true, message: tips.msg, type: 'error' });
					} 
					this.load.list = false;
				}).catch( err => this.load.list = false );
			},

			//显示编辑界面 XmProjectGroup xm_project_group
			showEdit: function ( row,index ) {
				this.editFormVisible = true;
				this.editForm = Object.assign({}, row);
			},
			//显示新增界面 XmProjectGroup xm_project_group
			showAdd: function () {
				this.addFormVisible = true;
				//this.addForm=Object.assign({}, this.editForm);
			},
			afterAddSubmit(){
				this.addFormVisible=false;
				this.pageInfo.count=true;
				this.getXmProjectGroups();
			},
			afterEditSubmit(){
				this.editFormVisible=false;
			},
			//选择行xmProjectGroup
			selsChange: function (sels) {
				this.sels = sels;
			}, 
			//删除xmProjectGroup
			handleDel: function (row,index) { 
				this.$confirm('确认删除该记录吗?', '提示', {
					type: 'warning'
				}).then(() => { 
					this.load.del=true;
					let params = { id: row.id };
					delXmProjectGroup(params).then((res) => {
						this.load.del=false;
						var tips=res.data.tips;
						if(tips.isOk){ 
							this.pageInfo.count=true;
							this.getXmProjectGroups();
						}
						this.$message({ showClose:true, message: tips.msg, type: tips.isOk?'success':'error' });
					}).catch( err  => this.load.del=false );
				});
			},
			//批量删除xmProjectGroup
			batchDel: function () {
				
				this.$confirm('确认删除选中记录吗？', '提示', {
					type: 'warning'
				}).then(() => { 
					this.load.del=true;
					batchDelXmProjectGroup(this.sels).then((res) => {
						this.load.del=false;
						var tips=res.data.tips;
						if( tips.isOk ){ 
							this.pageInfo.count=true;
							this.getXmProjectGroups(); 
						}
						this.$message({ showClose:true, message: tips.msg, type: tips.isOk?'success':'error'});
					}).catch( err  => this.load.del=false );
				});
			},
			rowClick: function(row, event, column){
			    if(event.label!='操作' && event.type!='selection'){
			        this.showEdit(row)
			    }
				this.$emit('row-click',row, event, column);//  @row-click="rowClick"
			},
            initData: function(){

            },
			
		},//end methods
		mounted() {
			this.$nextTick(() => {
			    //initSimpleDicts('all',['sex','gradeLvl']).then(res=>this.dicts=res.data.data);
			    this.initData()
				this.searchXmProjectGroups();
                var table=document.querySelector('.el-table');
                var top=util.getPositionTop(table)
                this.maxTableHeight = window.innerHeight - top -60;

        	});
		}
	}

</script>

<style scoped>
</style>