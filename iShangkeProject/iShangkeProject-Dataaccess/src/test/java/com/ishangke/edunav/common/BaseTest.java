package com.ishangke.edunav.common;

import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;

@Transactional
public class BaseTest extends TransactionalTestExecutionListener {

    protected String scriptBeforeClass;
    protected String scriptAfterClass;

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        if (!StringUtils.isEmpty(scriptBeforeClass)) {
            executeSqlScript(testContext, scriptBeforeClass);
        }
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        if (!StringUtils.isEmpty(scriptAfterClass)) {
            executeSqlScript(testContext, scriptAfterClass);
        }
    }

    private void executeSqlScript(TestContext testContext, String scriptName) throws Exception {
        if (StringUtils.isEmpty(scriptName)) {
            throw new IllegalArgumentException("Parameter scriptName is empty.");
        }

        JdbcTemplate jdbcTemplate = new JdbcTemplate((DataSource) testContext.getApplicationContext().getBean(
                "dataSource"));

        try (InputStream fileInputStream = Resources.getResourceAsStream(DataaccessConstants.TEST_RESOURCE_PATH_PREFIX
                + scriptName)) {
            Resource scriptResource = new InputStreamResource(fileInputStream);

            JdbcTestUtils.executeSqlScript(jdbcTemplate, scriptResource, false);
        }
    }
}
