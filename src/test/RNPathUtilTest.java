import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Test of RNPathUtil
 * Created by beansoft on 2017/8/25.
 */

public class RNPathUtilTest {

    @Test
    public void testJS() {
        // https://stackoverflow.com/questions/22492641/java8-js-nashorn-convert-array-to-java-array
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            engine.put("line", "刘长炯 微信号weblogic (10.3.2) [46a5432f8fdea99a6186a927e8da5db7a51854ac]");
//            engine.put("regex", )
            String regex = "/(.*?) \\((.*?)\\) \\[(.*?)\\]/";
            String[] value = (String[])engine.eval("Java.to(line.match(" + regex + "),\"java.lang.String[]\" );");
            System.out.println(value.length);
            System.out.println(value[1]);
            String[] result = {"刘长炯 微信号weblogic (10.3.2) [46a5432f8fdea99a6186a927e8da5db7a51854ac]",
                    "刘长炯 微信号weblogic", "10.3.2", "46a5432f8fdea99a6186a927e8da5db7a51854ac"};
            Assert.assertArrayEquals("result shold match", result, value);
//            Collection<Object> val = value.values();
//            if(value.isArray()) {
//                System.out.println(value.getMember("1"));
//            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}