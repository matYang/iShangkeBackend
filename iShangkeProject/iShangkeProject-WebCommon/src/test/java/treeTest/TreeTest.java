package treeTest;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.ishangke.edunav.web.common.DateUtility;
import com.ishangke.edunav.web.model.CategoryVo;
import com.ishangke.edunav.web.tree.TreeParser;

public class TreeTest {

    @Test
    public void testParse() {
        ArrayList<CategoryVo> catList = new ArrayList<CategoryVo>();
        CategoryVo cat1 = new CategoryVo();
        cat1.setValue("00");
        cat1.setName("语言培训");
        catList.add(cat1);
        
        CategoryVo cat2 = new CategoryVo();
        cat2.setValue("0000");
        cat2.setName("英语");
        catList.add(cat2);
        
        CategoryVo cat3 = new CategoryVo();
        cat3.setValue("000000");
        cat3.setName("雅思");
        catList.add(cat3);
        
        CategoryVo cat4 = new CategoryVo();
        cat4.setValue("000001");
        cat4.setName("四六级");
        catList.add(cat4);
        
        CategoryVo cat5 = new CategoryVo();
        cat5.setValue("000002");
        cat5.setName("托福");
        catList.add(cat5);
        
        CategoryVo cat6 = new CategoryVo();
        cat6.setValue("0001");
        cat6.setName("小语种");
        catList.add(cat6);
        
        CategoryVo cat7 = new CategoryVo();
        cat7.setValue("000100");
        cat7.setName("日语");
        catList.add(cat7);
        
        CategoryVo cat8 = new CategoryVo();
        cat8.setValue("000101");
        cat8.setName("韩语");
        catList.add(cat8);
        
        CategoryVo cat9 = new CategoryVo();
        cat9.setValue("000102");
        cat9.setName("法语");
        catList.add(cat9);
        
        CategoryVo cat10 = new CategoryVo();
        cat10.setValue("000103");
        cat10.setName("德语");
        catList.add(cat10);
        
        CategoryVo cat11 = new CategoryVo();
        cat11.setValue("000003");
        cat11.setName("GRE");
        catList.add(cat11);
        
        CategoryVo cat12 = new CategoryVo();
        cat12.setValue("02");
        cat12.setName("财会.金融");
        catList.add(cat12);
        
        CategoryVo cat13 = new CategoryVo();
        cat13.setValue("0201");
        cat13.setName("金融");
        catList.add(cat13);
        
        CategoryVo cat14 = new CategoryVo();
        cat14.setValue("0200");
        cat14.setName("财会会计");
        catList.add(cat14);
        
        CategoryVo cat15 = new CategoryVo();
        cat15.setValue("020003");
        cat15.setName("高级会计");
        catList.add(cat15);
        
        CategoryVo cat16 = new CategoryVo();
        cat16.setValue("020101");
        cat16.setName("证券从业员");
        catList.add(cat16);
        
        CategoryVo cat17 = new CategoryVo();
        cat17.setValue("010002");
        cat17.setName("数学");
        catList.add(cat17);
        
        CategoryVo cat18 = new CategoryVo();
        cat18.setValue("020000");
        cat18.setName("会计从业资格");
        catList.add(cat18);
        
        CategoryVo cat19 = new CategoryVo();
        cat19.setValue("020001");
        cat19.setName("初级会计");
        catList.add(cat19);
        
        CategoryVo cat20 = new CategoryVo();
        cat20.setValue("020100");
        cat20.setName("银行从业资格");
        catList.add(cat20);
        
        CategoryVo cat21 = new CategoryVo();
        cat21.setValue("020002");
        cat21.setName("中级会计");
        catList.add(cat21);
        
        
        CategoryVo cat31 = new CategoryVo();
        cat31.setValue("0100");
        cat31.setName("考研");
        catList.add(cat31);
        
        CategoryVo cat32 = new CategoryVo();
        cat32.setValue("01");
        cat32.setName("学历文凭");
        catList.add(cat32);

        
        CategoryVo cat22 = new CategoryVo();
        cat22.setValue("030100");
        cat22.setName("报关员");
        catList.add(cat22);
        
        CategoryVo cat23 = new CategoryVo();
        cat23.setValue("030002");
        cat23.setName("幼师资格");
        catList.add(cat23);
        
        CategoryVo cat33 = new CategoryVo();
        cat33.setValue("03");
        cat33.setName("资格认证");
        catList.add(cat33);
        
        CategoryVo cat24 = new CategoryVo();
        cat24.setValue("030000");
        cat24.setName("公务员");
        catList.add(cat24);
        
        CategoryVo cat34 = new CategoryVo();
        cat34.setValue("0300");
        cat34.setName("国家公职");
        catList.add(cat34);
        
        CategoryVo cat35 = new CategoryVo();
        cat35.setValue("0301");
        cat35.setName("外贸");
        catList.add(cat35);
        
        CategoryVo cat25 = new CategoryVo();
        cat25.setValue("030101");
        cat25.setName("跟单员");
        catList.add(cat25);
        
        CategoryVo cat26 = new CategoryVo();
        cat26.setValue("030001");
        cat26.setName("教师资格");
        catList.add(cat26);
        
        CategoryVo cat27 = new CategoryVo();
        cat27.setValue("000105");
        cat27.setName("意大利语");
        catList.add(cat27);
        
        CategoryVo cat28 = new CategoryVo();
        cat28.setValue("000005");
        cat28.setName("SAT");
        catList.add(cat28);
        
        CategoryVo cat29 = new CategoryVo();
        cat29.setValue("000104");
        cat29.setName("俄语");
        catList.add(cat29);
        
        CategoryVo cat30 = new CategoryVo();
        cat30.setValue("000004");
        cat30.setName("GMAT");
        catList.add(cat30);
        
        for (int i = 0; i < 170; i++) {
            catList.add(cat30);
        }
        
        for (int i = 0; i < catList.size(); i++) {
            catList.get(i).setId(i);
            catList.get(i).setRank(i);
            catList.get(i).setCreateTime(DateUtility.getCurTimeInstance());
            catList.get(i).setLastModifyTime(DateUtility.getCurTimeInstance());
            catList.get(i).setEnabled(1);
        }

        
        try {
            long startTime = System.nanoTime();
            for (int i = 0; i < 1; i++) {
                TreeParser.parse(catList);
            }
            long diff = System.nanoTime() - startTime;
            System.out.println("1 tree parse cost with shuffled: " + diff/1000000 + "ms " + diff%1000000 + "ns");
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
       
    }


}
