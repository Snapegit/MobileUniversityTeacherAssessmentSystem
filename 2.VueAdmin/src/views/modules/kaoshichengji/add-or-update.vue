<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"15px ","background":"#eeeeee"}'>
		<el-form
			:style='{"padding":"30px","boxShadow":"none","borderRadius":"0","flexWrap":"wrap","background":"#fff","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="80px"
		>
			<template >
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="考试名称" prop="kaoshimingcheng">
					<el-input v-model="ruleForm.kaoshimingcheng" placeholder="考试名称" clearable  :readonly="ro.kaoshimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="考试名称" prop="kaoshimingcheng">
					<el-input v-model="ruleForm.kaoshimingcheng" placeholder="考试名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="学期" prop="xueqi">
					<el-input v-model="ruleForm.xueqi" placeholder="学期" clearable  :readonly="ro.xueqi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="学期" prop="xueqi">
					<el-input v-model="ruleForm.xueqi" placeholder="学期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="学号" prop="xuehao">
					<el-input v-model="ruleForm.xuehao" placeholder="学号" clearable  :readonly="ro.xuehao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="学号" prop="xuehao">
					<el-input v-model="ruleForm.xuehao" placeholder="学号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="分数" prop="fenshu">
					<el-input v-model.number="ruleForm.fenshu" placeholder="分数" clearable  :readonly="ro.fenshu"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="分数" prop="fenshu">
					<el-input v-model="ruleForm.fenshu" placeholder="分数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="成绩" prop="chengji">
					<el-select :disabled="ro.chengji" v-model="ruleForm.chengji" placeholder="请选择成绩" >
						<el-option
							v-for="(item,index) in chengjiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="成绩" prop="chengji">
					<el-input v-model="ruleForm.chengji"
						placeholder="成绩" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="发布时间" prop="fabushijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.fabushijian" 
						type="datetime"
						:readonly="ro.fabushijian"
						placeholder="发布时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
					<el-input v-model="ruleForm.fabushijian" placeholder="发布时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="工号" prop="gonghao">
					<el-input v-model="ruleForm.gonghao" placeholder="工号" clearable  :readonly="ro.gonghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="工号" prop="gonghao">
					<el-input v-model="ruleForm.gonghao" placeholder="工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="教师姓名" prop="jiaoshixingming">
					<el-input v-model="ruleForm.jiaoshixingming" placeholder="教师姓名" clearable  :readonly="ro.jiaoshixingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else class="input" label="教师姓名" prop="jiaoshixingming">
					<el-input v-model="ruleForm.jiaoshixingming" placeholder="教师姓名" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="评价内容" prop="pingjianeirong">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="评价内容"
					  v-model="ruleForm.pingjianeirong" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0"}' v-else-if="ruleForm.pingjianeirong" label="评价内容" prop="pingjianeirong">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}'>{{ruleForm.pingjianeirong}}</span>
				</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
import { 
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				kaoshimingcheng : false,
				xueqi : false,
				xuehao : false,
				xingming : false,
				fenshu : false,
				chengji : false,
				pingjianeirong : false,
				fabushijian : false,
				gonghao : false,
				jiaoshixingming : false,
			},
			
			
			ruleForm: {
				kaoshimingcheng: '',
				xueqi: '',
				xuehao: '',
				xingming: '',
				fenshu: '',
				chengji: '',
				pingjianeirong: '',
				fabushijian: '',
				gonghao: '',
				jiaoshixingming: '',
			},
		
			chengjiOptions: [],

			
			rules: {
				kaoshimingcheng: [
					{ required: true, message: '考试名称不能为空', trigger: 'blur' },
				],
				xueqi: [
					{ required: true, message: '学期不能为空', trigger: 'blur' },
				],
				xuehao: [
				],
				xingming: [
				],
				fenshu: [
					{ required: true, message: '分数不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				chengji: [
					{ required: true, message: '成绩不能为空', trigger: 'blur' },
				],
				pingjianeirong: [
				],
				fabushijian: [
				],
				gonghao: [
				],
				jiaoshixingming: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.fabushijian = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='kaoshimingcheng'){
							this.ruleForm.kaoshimingcheng = obj[o];
							this.ro.kaoshimingcheng = true;
							continue;
						}
						if(o=='xueqi'){
							this.ruleForm.xueqi = obj[o];
							this.ro.xueqi = true;
							continue;
						}
						if(o=='xuehao'){
							this.ruleForm.xuehao = obj[o];
							this.ro.xuehao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='fenshu'){
							this.ruleForm.fenshu = obj[o];
							this.ro.fenshu = true;
							continue;
						}
						if(o=='chengji'){
							this.ruleForm.chengji = obj[o];
							this.ro.chengji = true;
							continue;
						}
						if(o=='pingjianeirong'){
							this.ruleForm.pingjianeirong = obj[o];
							this.ro.pingjianeirong = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
							continue;
						}
						if(o=='gonghao'){
							this.ruleForm.gonghao = obj[o];
							this.ro.gonghao = true;
							continue;
						}
						if(o=='jiaoshixingming'){
							this.ruleForm.jiaoshixingming = obj[o];
							this.ro.jiaoshixingming = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.fabushijian = true;
					}
					if(((json.gonghao!=''&&json.gonghao) || json.gonghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gonghao = json.gonghao
						this.ro.gonghao = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.gonghao = true;
					}
					if(((json.jiaoshixingming!=''&&json.jiaoshixingming) || json.jiaoshixingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.jiaoshixingming = json.jiaoshixingming
						this.ro.jiaoshixingming = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.jiaoshixingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
            this.chengjiOptions = "优秀,良好,及格,不及格".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `kaoshichengji/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "kaoshichengji/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `kaoshichengji/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.kaoshichengjiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `kaoshichengji/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.kaoshichengjiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.kaoshichengjiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #9E9E9E;
	  	  font-weight: 500;
	  	  width: 80px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  	  border: 1px solid #C8C8C8;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number ::v-deep .el-input__inner {
		text-align: left;
	  	  border: 1px solid #C8C8C8;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  	  border: 1px solid #C8C8C8;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: 1px solid #C8C8C8;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  	  border: 1px solid #C8C8C8;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview ::v-deep .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview ::v-deep .upload .upload-img {
	  	  border: 1px solid    #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #000000;
	  	  font-weight: bold;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  	  border: 1px solid    #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #000000;
	  	  font-weight: bold;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  	  border: 1px solid    #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #000000;
	  	  font-weight: bold;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  	  border: 1px solid    #C8C8C8;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color:  #C8C8C8;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6C549C;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6C549C;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #A68DF5;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #A68DF5;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #A68DF5;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
