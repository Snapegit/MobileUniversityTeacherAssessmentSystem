<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"120rpx 74rpx","background":"url(http://codegen.caihongy.cn/20240125/a7e99308e1e94a92b0944143957453f2.webp)no-repeat center center/604rpx 90%,url(http://codegen.caihongy.cn/20240125/59932b5d11c74ee8ac1d57c4bb86117a.webp)no-repeat 50% 50%/110% 110%"}'>
		<view :style='{"padding":"100rpx 72rpx","overflow":"auto","flexDirection":"column","display":"flex","width":"auto","position":"relative","height":"100%"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">工号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","background":"rgba(0, 0, 0, 0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}'  v-model="ruleForm.gonghao"  type="text"  class="uni-input" name="" placeholder="工号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","background":"rgba(0, 0, 0, 0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">确认密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","background":"rgba(0, 0, 0, 0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">教师姓名：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","background":"rgba(0, 0, 0, 0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}'  v-model="ruleForm.jiaoshixingming"  type="text"  class="uni-input" name="" placeholder="教师姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" @tap="jiaoshitouxiangTap" class="">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">头像：</view>
				<image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">性别：</view>
				<picker :style='{"margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'"  @change="jiaoshixingbieChange" :value="jiaoshixingbieIndex" :range="jiaoshixingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","color":"#fff","borderRadius":"40rpx","flex":"1","background":"rgba(0, 0, 0, 0.5)","width":"458rpx","lineHeight":"72rpx","fontSize":"24rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">职称：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","background":"rgba(0, 0, 0, 0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}'  v-model="ruleForm.zhicheng"  type="text"  class="uni-input" name="" placeholder="职称" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">邮箱：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","background":"rgba(0, 0, 0, 0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}'  v-model="ruleForm.youxiang"  type="text"  class="uni-input" name="" placeholder="邮箱" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"128rpx","lineHeight":"44rpx","fontSize":"24rpx","color":"#000000"}' class="label">电话：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","background":"rgba(0, 0, 0, 0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}'  v-model="ruleForm.dianhua"  type="text"  class="uni-input" name="" placeholder="电话" />
			</view>
			<button :style='{"border":"0","padding":"0px","margin":"0 auto","color":"rgb(255, 255, 255)","borderRadius":"40rpx","background":"rgba(106, 182, 236, 1)","width":"200rpx","lineHeight":"72rpx","fontSize":"32rpx","height":"72rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                jiaoshixingbieOptions: [],
                jiaoshixingbieIndex: 0,
				ruleForm: {
                gonghao: '',
                mima: '',
                jiaoshixingming: '',
                touxiang: '',
                xingbie: '',
                zhicheng: '',
                youxiang: '',
                dianhua: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='jiaoshi'){
                this.jiaoshixingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.jiaoshixingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            jiaoshitouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            jiaoshixingbieChange(e) {
                    this.jiaoshixingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.jiaoshixingbieOptions[this.jiaoshixingbieIndex]
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.gonghao) && `jiaoshi` == this.tableName){
					this.$utils.msg(`工号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `jiaoshi` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`jiaoshi` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.jiaoshixingming) && `jiaoshi` == this.tableName){
					this.$utils.msg(`教师姓名不能为空`);
					return
				}
				if(`jiaoshi` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
				if(`jiaoshi` == this.tableName && this.ruleForm.dianhua&&(!this.$validate.isMobile(this.ruleForm.dianhua))){
					this.$utils.msg(`电话应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
