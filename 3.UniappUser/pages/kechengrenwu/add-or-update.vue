<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"32rpx 20rpx","position":"relative","background":"#E0F0FD"}'>
		<form :style='{"border":"28rpx solid #6AB6EC","padding":"24rpx","borderRadius":"20rpx","background":"#fff","display":"block","width":"100%","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">任务名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.renwumingcheng" v-model="ruleForm.renwumingcheng" placeholder="任务名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="" @tap="tupianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">工号</view>
				<picker :disabled="ro.gonghao" :style='{"width":"100%","flex":"1","height":"auto"}' @change="gonghaoChange" :value="gonghaoIndex" :range="gonghaoOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#6AB6EC"}' class="uni-input">{{gonghaoOptions[gonghaoIndex]}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">教师姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' disabled v-model="ruleForm.jiaoshixingming" placeholder="教师姓名"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">上课时间</view>
				<picker  :disabled="ro.shangkeshijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.shangkeshijian" @change="shangkeshijianChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#6AB6EC"}' class="uni-input">{{ruleForm.shangkeshijian?ruleForm.shangkeshijian:"请选择上课时间"}}</view>
				</picker>
			</view>
 

			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">课程分配</view>
				<textarea :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.kechengfenpei" placeholder="课程分配"></textarea>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">任务要求</view>
				<textarea :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.renwuyaoqiu" placeholder="任务要求"></textarea>
			</view>
			
			<view :style='{"width":"100%","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0","color":"rgb(255, 255, 255)","borderRadius":"40rpx","background":"#6AB6EC","width":"48%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				renwumingcheng: '',
				tupian: '',
				gonghao: '',
				jiaoshixingming: '',
				shangkeshijian: '',
				kechengfenpei: '',
				renwuyaoqiu: '',
				},
				gonghaoOptions: [],
				gonghaoIndex: 0,
				// 登录用户信息
				user: {},
                ro:{
                   renwumingcheng : false,
                   tupian : false,
                   gonghao : false,
                   jiaoshixingming : false,
                   shangkeshijian : false,
                   kechengfenpei : false,
                   renwuyaoqiu : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor,
            multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取

            this.ro.jiaoshixingming = true;

			// 下2
			res = await this.$api.option(`jiaoshi`,`gonghao`,{});
			this.gonghaoOptions = res.data;

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`kechengrenwu`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='renwumingcheng'){
					this.ruleForm.renwumingcheng = obj[o];
					this.ro.renwumingcheng = true;
					continue;
					}
					if(o=='tupian'){
					this.ruleForm.tupian = obj[o].split(",")[0];
					this.ro.tupian = true;
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
					if(o=='shangkeshijian'){
					this.ruleForm.shangkeshijian = obj[o];
					this.ro.shangkeshijian = true;
					continue;
					}
					if(o=='kechengfenpei'){
					this.ruleForm.kechengfenpei = obj[o];
					this.ro.kechengfenpei = true;
					continue;
					}
					if(o=='renwuyaoqiu'){
					this.ruleForm.renwuyaoqiu = obj[o];
					this.ro.renwuyaoqiu = true;
					continue;
					}
				}
			}
			this.styleChange()
            this.$forceUpdate()
			
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},
			// 下二随
			async gonghaoChange (e) {
				this.gonghaoIndex = e.target.value
				this.ruleForm.gonghao = this.gonghaoOptions[this.gonghaoIndex]
				let res = await this.$api.follow(`jiaoshi`, `gonghao`,{
					columnValue: this.ruleForm.gonghao
				});
				if(res.data.jiaoshixingming){
					this.ruleForm.jiaoshixingming = res.data.jiaoshixingming
				}
			},

			// 多级联动参数

			shangkeshijianChange(e) {
				this.ruleForm.shangkeshijian = e.target.value;
				this.$forceUpdate();
			},



			tupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.tupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
//跨表计算判断
				var obj;
				if((!this.ruleForm.renwumingcheng)){
					this.$utils.msg(`任务名称不能为空`);
					return
				}
				if((!this.ruleForm.gonghao)){
					this.$utils.msg(`工号不能为空`);
					return
				}
				if((!this.ruleForm.shangkeshijian)){
					this.$utils.msg(`上课时间不能为空`);
					return
				}
				if((!this.ruleForm.kechengfenpei)){
					this.$utils.msg(`课程分配不能为空`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
                    uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('appUserid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`kechengrenwu`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`kechengrenwu`, this.ruleForm);
						}else{
							await this.$api.add(`kechengrenwu`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`kechengrenwu`, this.ruleForm);
					}else{
						await this.$api.add(`kechengrenwu`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
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
