<template>
	<div>
		<div class="container" :style='{"width":"100%","backgroundSize":"cover","backgroundRepeat":"no-repeat","backgroundImage":"url(http://codegen.caihongy.cn/20231215/038e28a60a834ab68895538aeae8e71d.png)","display":"flex","height":"100%"}'>
			<el-form v-if="pageFlag=='register'" :style='{"width":"35%","boxShadow":"none","margin":"0 0 0 0","background":"#fff","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"40px 20px 20px","margin":"0 0 10px 0","color":"#000000","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"18px","textShadow":"none"}' class="title">基于springboot+vue的大学教师考核管理系统的设计与实现注册</div>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('gonghao')?'required':''">工号：</div>
					<el-input  v-model="ruleForm.gonghao"  autocomplete="off" placeholder="工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('jiaoshixingming')?'required':''">教师姓名：</div>
					<el-input  v-model="ruleForm.jiaoshixingming"  autocomplete="off" placeholder="教师姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="jiaoshitouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in jiaoshixingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('zhicheng')?'required':''">职称：</div>
					<el-input  v-model="ruleForm.zhicheng"  autocomplete="off" placeholder="职称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('youxiang')?'required':''">邮箱：</div>
					<el-input  v-model="ruleForm.youxiang"  autocomplete="off" placeholder="邮箱"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0 0 20px 0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"rgba(64, 158, 255, 1)"}' class="lable" :class="changeRules('dianhua')?'required':''">电话：</div>
					<el-input  v-model="ruleForm.dianhua"  autocomplete="off" placeholder="电话"  type="text"  />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"none","margin":"40px auto 5px","color":"#FFFFFF","display":"block","outline":"none","borderRadius":"8px","background":"#A68DF5","width":"60%","fontSize":"24px","fontWeight":"700","height":"44px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","margin":"20px 0 0 32%","color":"#A68DF5","display":"inline-block","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            jiaoshixingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='jiaoshi'){
				this.ruleForm = {
					gonghao: '',
					mima: '',
					jiaoshixingming: '',
					touxiang: '',
					xingbie: '',
					zhicheng: '',
					youxiang: '',
					dianhua: '',
				}
			}
			if ('jiaoshi' == this.tableName) {
				this.rules.gonghao = [{ required: true, message: '请输入工号', trigger: 'blur' }]
			}
			if ('jiaoshi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiaoshi' == this.tableName) {
				this.rules.jiaoshixingming = [{ required: true, message: '请输入教师姓名', trigger: 'blur' }]
			}
			this.jiaoshixingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        jiaoshitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.gonghao) && `jiaoshi` == this.tableName){
						this.$message.error(`工号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `jiaoshi` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiaoshi` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.jiaoshixingming) && `jiaoshi` == this.tableName){
						this.$message.error(`教师姓名不能为空`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`jiaoshi` == this.tableName && this.ruleForm.youxiang &&(!this.$validate.isEmail(this.ruleForm.youxiang))){
						this.$message.error(`邮箱应输入邮件格式`);
						return
					}
					if(`jiaoshi` == this.tableName && this.ruleForm.dianhua &&(!this.$validate.isMobile(this.ruleForm.dianhua))){
						this.$message.error(`电话应输入手机格式`);
						return
					}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input ::v-deep .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px;
						box-shadow: none;
						outline: none;
						color: #A5A5A5;
						background: #F8F8F7;
						font-weight: 400;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select ::v-deep .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px;
						box-shadow: noen;
						outline: none;
						color: #A5A5A5;
						background: #F8F8F7;
						width: calc(100vw -  79vw);
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #A5A5A5;
						background: #F8F8F7;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #A5A5A5;
						background: #F8F8F7;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form ::v-deep .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form ::v-deep .upload .upload-img {
		  		  border: none;
		  		  cursor: pointer;
		  		  border-radius: 10px;
		  		  color: #3D3D3D;
		  		  background: #F8F8F7;
		  		  object-fit: cover;
		  		  width: 80px;
		  		  font-size: 24px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form ::v-deep .el-upload-list .el-upload-list__item {
		  		  border: none;
		  		  cursor: pointer;
		  		  border-radius: 10px;
		  		  color: #3D3D3D;
		  		  background: #F8F8F7;
		  		  object-fit: cover;
		  		  width: 80px;
		  		  font-size: 24px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form ::v-deep .el-upload .el-icon-plus {
		  		  border: none;
		  		  cursor: pointer;
		  		  border-radius: 10px;
		  		  color: #3D3D3D;
		  		  background: #F8F8F7;
		  		  object-fit: cover;
		  		  width: 80px;
		  		  font-size: 24px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: -10px;
				position: absolute;
				content: "*";
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
