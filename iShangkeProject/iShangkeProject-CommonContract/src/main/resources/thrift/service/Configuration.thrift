include "model/fault.thrift"
include "model/configuration.thrift"

namespace java com.ishangke.edunav.commoncontract.service   
   
service ConfigurationService{
   
   /**********************************************************
    *
    *   Configuration
    *
    **********************************************************/
    configuration.ConfigurationBo getConfigurationByName(1: string name) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    configuration.ConfigurationPageViewBo listAllConfiguration() throws (1: fault.BusinessExceptionBo businessExceptionBo)
}