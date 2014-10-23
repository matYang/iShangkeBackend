namespace java com.ishangke.edunav.commoncontract.model

struct PartnerCategoryBo {
    1: i32 id
    2: i32 partnerId
    3: i32 categoryId
}
struct PartnerCategoryPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<PartnerCategoryBo> data
} 