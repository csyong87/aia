package com.techmahindra;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * <p>
 * As part of the automated unit test package for BPMS service package, the assertions used in these tests are dependent
 * on the data contained in the <strong>initial-data-1.sql</strong>
 * </p>
 *
 * <p>
 * This class provides a common location for initializing spring configurations
 * </p>
 *
 * @author Christian
 *
 */
@ContextConfiguration(locations = { "classpath:/applicationContext-aia-dao.xml",
        "classpath:/applicationContext-resources.xml"})
public class UnitTestBase extends AbstractTransactionalJUnit4SpringContextTests {
}
