<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"32rpx 20rpx","position":"relative","background":"#E0F0FD"}'>
		<form :style='{"border":"28rpx solid #6AB6EC","padding":"24rpx","borderRadius":"20rpx","background":"#fff","display":"block","width":"100%","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">课程编号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.kechengbianhao" v-model="ruleForm.kechengbianhao" placeholder="课程编号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">课程名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.kechengmingcheng" v-model="ruleForm.kechengmingcheng" placeholder="课程名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">课程类型</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.kechengleixing" v-model="ruleForm.kechengleixing" placeholder="课程类型"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="" @tap="tupianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">班级</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.banji" v-model="ruleForm.banji" placeholder="班级"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">开课时间</view>
				<input :disabled="ro.kaikeshijian" :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.kaikeshijian" placeholder="开课时间" @tap="toggleTab('kaikeshijian')"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">上课地点</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shangkedidian" v-model="ruleForm.shangkedidian" placeholder="上课地点"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">工号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.gonghao" v-model="ruleForm.gonghao" placeholder="工号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">教师姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jiaoshixingming" v-model="ruleForm.jiaoshixingming" placeholder="教师姓名"  type="text"></input>
			</view>
 

			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">课程介绍</view>
				<textarea :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.kechengjieshao" placeholder="课程介绍"></textarea>
			</view>
			
			<view :style='{"width":"100%","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0","color":"rgb(255, 255, 255)","borderRadius":"40rpx","background":"#6AB6EC","width":"48%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker :starttime="kaikeshijianstarttime" mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="kaikeshijianConfirm" ref="kaikeshijian" themeColor="#333333"></w-picker>
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
				kechengbianhao: '',
				kechengmingcheng: '',
				kechengleixing: '',
				tupian: '',
				banji: '',
				kaikeshijian: '',
				shangkedidian: '',
				kechengjieshao: '',
				gonghao: '',
				jiaoshixingming: '',
				storeupnum: '',
				},
				kaikeshijianstarttime: '',
				// 登录用户信息
				user: {},
                ro:{
                   kechengbianhao : false,
                   kechengmingcheng : false,
                   kechengleixing : false,
                   tupian : false,
                   banji : false,
                   kaikeshijian : false,
                   shangkedidian : false,
                   kechengjieshao : false,
                   gonghao : false,
                   jiaoshixingming : false,
                   storeupnum : false,
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
			this.kaikeshijianstarttime = this.$utils.getCurDate()
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.gonghao = this.user.gonghao
			this.ro.gonghao = true;
			this.ruleForm.jiaoshixingming = this.user.jiaoshixingming
			this.ro.jiaoshixingming = true;



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
				res = await this.$api.info(`kechengxinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='kechengbianhao'){
					this.ruleForm.kechengbianhao = obj[o];
					this.ro.kechengbianhao = true;
					continue;
					}
					if(o=='kechengmingcheng'){
					this.ruleForm.kechengmingcheng = obj[o];
					this.ro.kechengmingcheng = true;
					continue;
					}
					if(o=='kechengleixing'){
					this.ruleForm.kechengleixing = obj[o];
					this.ro.kechengleixing = true;
					continue;
					}
					if(o=='tupian'){
					this.ruleForm.tupian = obj[o].split(",")[0];
					this.ro.tupian = true;
					continue;
					}
					if(o=='banji'){
					this.ruleForm.banji = obj[o];
					this.ro.banji = true;
					continue;
					}
					if(o=='kaikeshijian'){
					this.ruleForm.kaikeshijian = obj[o];
					this.ro.kaikeshijian = true;
					continue;
					}
					if(o=='shangkedidian'){
					this.ruleForm.shangkedidian = obj[o];
					this.ro.shangkedidian = true;
					continue;
					}
					if(o=='kechengjieshao'){
					this.ruleForm.kechengjieshao = obj[o];
					this.ro.kechengjieshao = true;
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
					if(o=='storeupnum'){
					this.ruleForm.storeupnum = obj[o];
					this.ro.storeupnum = true;
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

			// 多级联动参数


			// 日长控件选择日期时间
			kaikeshijianConfirm(val) {
				console.log(val)
				this.ruleForm.kaikeshijian = val.result;
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
				if((!this.ruleForm.kechengbianhao)){
					this.$utils.msg(`课程编号不能为空`);
					return
				}
				if((!this.ruleForm.kechengmingcheng)){
					this.$utils.msg(`课程名称不能为空`);
					return
				}
				if((!this.ruleForm.banji)){
					this.$utils.msg(`班级不能为空`);
					return
				}
				if((!this.ruleForm.kaikeshijian)){
					this.$utils.msg(`开课时间不能为空`);
					return
				}
				if((!this.ruleForm.shangkedidian)){
					this.$utils.msg(`上课地点不能为空`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
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
					let res = await this.$api.list(`kechengxinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`kechengxinxi`, this.ruleForm);
						}else{
							await this.$api.add(`kechengxinxi`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`kechengxinxi`, this.ruleForm);
					}else{
						await this.$api.add(`kechengxinxi`, this.ruleForm);
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
