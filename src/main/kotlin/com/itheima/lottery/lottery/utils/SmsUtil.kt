package com.itheima.lottery.lottery.utils

import com.aliyuncs.DefaultAcsClient
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest
import com.aliyuncs.exceptions.ClientException
import com.aliyuncs.profile.DefaultProfile
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Component
class SmsUtil {

    //产品名称:云通信短信API产品,开发者无需替换
    val product = "Dysmsapi"
    //产品域名,开发者无需替换
    val domain = "dysmsapi.aliyuncs.com"
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    //替换成你的ApiKey
    @Value("\${accessKeyId}")
    private lateinit var accessKeyId: String

    @Value("\${accessKeySecret}")
    private lateinit var accessKeySecret: String


    /**
     * 发送一个短信
     */
    @Throws(ClientException::class)
    fun sendSms(phone: String): String {
        println("$accessKeyId-$accessKeySecret")
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000")
        System.setProperty("sun.net.client.defaultReadTimeout", "10000")

        //初始化acsClient,暂不支持region化
        val profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret)
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain)
        val acsClient = DefaultAcsClient(profile)

        //组装请求对象-具体描述见控制台-文档部分内容
        val request = SendSmsRequest()
        //必填:待发送手机号
        request.setPhoneNumbers(phone)
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("深圳黑马")
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_127161028")
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        val smscode = (Math.random() * 1000000).toLong().toString() + ""  //0-999999
        println("短信验证码：$smscode")
        //我的模版内容为: 验证码为：123456，5分钟内有效,打死也不要告诉别人哦!
        request.setTemplateParam("{\"code\":\"$smscode\"}")

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId")

        //hint 此处可能会抛出异常，注意catch
        val response = acsClient.getAcsResponse(request)
        if (response.getCode() != null && response.getCode().equals("OK")) {
            //代表的是发送成功
        } else {
            println("短信接口返回的数据----------------")
            System.out.println("Code=" + response.getCode())
            System.out.println("Message=" + response.getMessage())
            System.out.println("RequestId=" + response.getRequestId())
            System.out.println("BizId=" + response.getBizId())
        }
        return smscode
    }


}