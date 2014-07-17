include "model/user.thrift"
include "model/partner.thrift"
include "model/course.thrift"
include "model/fault.thrift"
include "model/common.thrift"
include "model/spread.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service SpreadService{
	
    /**
     *  生成识别码。<br>
     *  每条推广信息都需要独立的识别码
     *
     *  @param  userBo          发布推广信息的用户
     *  @param  partnerBo       用户推广的机构信息
     *  @param  courseBo        用户推广的课程信息
     *  @param  iShangkeBo      用户推广的爱上课信息
     *
     *  @return 创建完毕的识别码
     *
     */ 
    spread.SpreadBo generateCode(1: user.UserBo userBo, 2: partner.PartnerBo partnerBo, 3: course.CourseBo courseBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询推广信息。<br>
     *  管理员可以查询推广信息
     *
     *  @param  spreadBo           需要查询的推广信息
     *  @param  userBo             推广相关的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return 推广信息实体 SpreadBo 列表
     *
     */ 
    list<spread.SpreadBo> query(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  创建推广信息。<br>
     *  用户可以创建推广信息，以供管理员审查
     *
     *  @param  spreadBo        需要创建的推广信息
     *  @param  partnerBo       用户推广的机构信息
     *  @param  courseBo        用户推广的课程信息
     *  @param  iShangkeBo      用户推广的爱上课信息
     *  @param  userBo          发布推广信息的用户
     *
     *  @return 创建完毕的推广信息
     *
     */ 
    spread.SpreadBo createSpread(1: spread.SpreadBo spreadBo, 2: partner.PartnerBo partnerBo, 3: course.CourseBo courseBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  认可推广信息。<br>
     *  管理员可以审核认可用户发布的推广信息
     *
     *  @param  spreadBo           待认可的推广信息
     *  @param  userBo             发起认可的管理员信息
     *
     *  @return 认可之后的推广信息
     *
     */
    spread.SpreadBo approveSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  拒绝推广信息。<br>
     *  管理员可以审核拒绝用户发布的推广信息
     *
     *  @param  spreadBo           待拒绝的推广信息
     *  @param  userBo             发起拒绝的管理员信息
     *
     *  @return 拒绝之后的推广信息
     *
     */
    spread.SpreadBo rejectSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  取消推广信息。<br>
     *  用户可以取消待审核的推广信息
     *
     *  @param  spreadBo           待取消的推广信息
     *  @param  userBo             发起取消的用户信息
     *
     *  @return 取消之后的推广信息
     *
     */
    spread.SpreadBo cancelSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  删除推广信息。<br>
     *  用户可以删除推广信息记录
     *
     *  @param  spreadBo           待删除的推广信息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 删除之后的推广信息
     *
     */
    spread.SpreadBo deleteSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}