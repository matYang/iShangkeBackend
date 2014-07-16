include "common.thrift"

namespace java com.ishangke.edunav.commoncontract.model

/**
 * BusinessExceptionBo
 */
exception BusinessExceptionBo {
  1: i32 errorCode
  2: string messageKey
}

