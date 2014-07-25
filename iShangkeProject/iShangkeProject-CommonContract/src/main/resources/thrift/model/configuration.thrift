namespace java com.ishangke.edunav.commoncontract.model

struct ConfigurationBo {
  1: i32 id
  2: string name
  3: string configData
}
struct ConfigurationBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<ConfigurationBo> data
} 