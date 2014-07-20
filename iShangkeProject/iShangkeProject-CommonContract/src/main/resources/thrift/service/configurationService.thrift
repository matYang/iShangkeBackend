include "model/fault.thrift"
include "model/configuration.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service ConfigurationService{
    string getByName(1: string name) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    list<configuration.ConfigurationBo> listAll() throws (1: fault.BusinessExceptionBo businessExceptionBo)
}