<template>
	<view class="content">
		<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"60rpx 60rpx 100rpx","background":"url(http://codegen.caihongy.cn/20240111/c6d75b07c6ab47d2bc3d56c0dc06d020.webp)no-repeat 50% 50%/110% 110%"}'>
			<view :style='{"padding":"72rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20240111/9846c595100a491c9f0e98e6b2ffdcfc.webp)no-repeat 0 0/100% 100%","display":"flex","width":"100%","position":"relative","justifyContent":"center","height":"auto"}'>
				<image :style='{"width":"120rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"block","height":"120rpx"}' src="http://codegen.caihongy.cn/20240111/d59138977ec746ff8c5353075e849ac4.png" mode="aspectFill"></image>
				<view v-if="loginType==1" :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"width":"100%","lineHeight":"56rpx","fontSize":"24rpx","color":"#000000"}' class="label">账号：</view>
					<input v-model="username" :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","flex":"1","background":"rgba(0, 0, 0,0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view v-if="loginType==1" :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"width":"100%","lineHeight":"56rpx","fontSize":"24rpx","color":"#000000"}' class="label">密码：</view>
					<input v-model="password" :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"40rpx","flex":"1","background":"rgba(0, 0, 0,0.5)","width":"100%","fontSize":"28rpx","height":"72rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<view v-if="roleNum>1" :style='{"width":"100%","margin":"0 0 24rpx 0","flexWrap":"wrap","display":"flex","height":"auto"}'>
					<view :style='{"width":"100%","lineHeight":"56rpx","fontSize":"24rpx","color":"#000000"}' class="label">用户类型：</view>
					<picker @change="optionsChange" :value="index" :range="options" :style='{"padding":"0 20rpx","color":"#fff","borderRadius":"40rpx","flex":"1","background":"rgba(0, 0, 0,0.5)","lineHeight":"72rpx","fontSize":"28rpx"}'>
						<view class="uni-picker-type">{{options[index]}}</view>
					</picker>
				</view>
				

				
				<button v-if="loginType==1" class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"40rpx","background":"#6AB6EC","width":"auto","lineHeight":"72rpx","fontSize":"32rpx","minWidth":"200rpx","height":"72rpx"}'>登陆</button>
				<button v-if="loginType==2" class="btn-submit" @tap="onFaceLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"40rpx","background":"#6AB6EC","width":"auto","lineHeight":"72rpx","fontSize":"32rpx","minWidth":"200rpx","height":"72rpx"}'>人脸识别登录</button>
				<view class="links" :style='{"row-gap":"20rpx","padding":"0","columnGap":"20rpx","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"center","height":"auto"}'>
					<view class="link-highlight" @tap="onRegisterTap('jiaoshi')" :style='{"padding":"0 8rpx","color":"#fff","borderRadius":"40rpx","textAlign":"center","background":"#6AB6EC","fontSize":"28rpx","minWidth":"200rpx","lineHeight":"72rpx"}'>注册教师</view>
				</view>
				
				<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
				<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
				<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
                loginType:1,
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型',
				],
                optionsValues: [
					'',
                    'jiaoshi',
				],
				index: 0,
				roleNum:0,

			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.styleChange()
		},
		onShow() {
		},
		mounted() {
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			async onLoginTap() {
                if (!this.username) {
					this.$utils.msg('请输入用户名')
					return
				}
                if (!this.password) {
					this.$utils.msg('请输入用户密码')
					return
				}
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登录用户类型')
					return
				}

				this.loginPost()

			},
			async loginPost() {
				
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
				uni.removeStorageSync("useridTag");
				uni.setStorageSync("appToken", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				if(res.data.touxiang) {
				    uni.setStorageSync('headportrait', res.data.touxiang);
				} else if(res.data.headportrait) {
				    uni.setStorageSync('headportrait', res.data.headportrait);
				}
				uni.setStorageSync('userSession',JSON.stringify(res.data))
				// 保存用户id
				uni.setStorageSync("appUserid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		height: 100%;
	}
	
	.content {
		height: 100%;
		box-sizing: border-box;
	}
	
</style>
