<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"32rpx 20rpx","position":"relative","background":"#E0F0FD"}'>
		<form :style='{"border":"28rpx solid #6AB6EC","padding":"24rpx","borderRadius":"20rpx","background":"#fff","display":"block","width":"100%","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">考试名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.kaoshimingcheng" v-model="ruleForm.kaoshimingcheng" placeholder="考试名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">学期</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xueqi" v-model="ruleForm.xueqi" placeholder="学期"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">学号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xuehao" v-model="ruleForm.xuehao" placeholder="学号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xingming" v-model="ruleForm.xingming" placeholder="姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">分数</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.fenshu" v-model.number="ruleForm.fenshu" placeholder="分数" type="number"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">成绩</view>
				<picker :disabled="ro.chengji" :style='{"width":"100%","flex":"1","height":"auto"}' @change="chengjiChange" :value="chengjiIndex" :range="chengjiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#6AB6EC"}' class="uni-input">{{ruleForm.chengji?ruleForm.chengji:"请选择成绩"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">发布时间</view>
				<input :disabled="ro.fabushijian" :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.fabushijian" placeholder="发布时间" @tap="toggleTab('fabushijian')"></input>
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
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"24rpx","color":"#333","textAlign":"left"}' class="title">评价内容</view>
				<textarea :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#EBEBEB","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.pingjianeirong" placeholder="评价内容"></textarea>
			</view>
			
			<view :style='{"width":"100%","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0","color":"rgb(255, 255, 255)","borderRadius":"40rpx","background":"#6AB6EC","width":"48%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="fabushijianConfirm" ref="fabushijian" themeColor="#333333"></w-picker>
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
				chengjiIndex: 0,
				// 登录用户信息
				user: {},
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
            this.ruleForm.fabushijian =  this.$utils.getCurDateTime();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.gonghao = this.user.gonghao
			this.ro.gonghao = true;
			this.ruleForm.jiaoshixingming = this.user.jiaoshixingming
			this.ro.jiaoshixingming = true;

            this.ro.fabushijian = true;
            this.ro.gonghao = true;
            this.ro.jiaoshixingming = true;

			// 自定义下拉框值
			this.chengjiOptions = "优秀,良好,及格,不及格".split(',')

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
				res = await this.$api.info(`kaoshichengji`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
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
			fabushijianConfirm(val) {
				console.log(val)
				this.ruleForm.fabushijian = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			chengjiChange(e) {
				this.chengjiIndex = e.target.value
				this.ruleForm.chengji = this.chengjiOptions[this.chengjiIndex]
			},


			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
//跨表计算判断
				var obj;
				if((!this.ruleForm.kaoshimingcheng)){
					this.$utils.msg(`考试名称不能为空`);
					return
				}
				if((!this.ruleForm.xueqi)){
					this.$utils.msg(`学期不能为空`);
					return
				}
				if((!this.ruleForm.fenshu)){
					this.$utils.msg(`分数不能为空`);
					return
				}
				if(this.ruleForm.fenshu&&(!this.$validate.isIntNumer(this.ruleForm.fenshu))){
					this.$utils.msg(`分数应输入整数`);
					return
				}
				if((!this.ruleForm.chengji)){
					this.$utils.msg(`成绩不能为空`);
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
					let res = await this.$api.list(`kaoshichengji`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`kaoshichengji`, this.ruleForm);
						}else{
							await this.$api.add(`kaoshichengji`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`kaoshichengji`, this.ruleForm);
					}else{
						await this.$api.add(`kaoshichengji`, this.ruleForm);
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
