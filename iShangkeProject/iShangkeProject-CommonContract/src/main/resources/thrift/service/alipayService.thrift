include "model/fault.thrift"
namespace java com.ishangke.edunav.commoncontract.service

service AlipayService{

string verify(1: string notify)throws (1: fault.BusinessExceptionBo businessExceptionBo)
string buildFormForGet(1:string subject, 2: string out_trade_no, 3: string total_fee)throws (1: fault.BusinessExceptionBo businessExceptionBo)
     

}