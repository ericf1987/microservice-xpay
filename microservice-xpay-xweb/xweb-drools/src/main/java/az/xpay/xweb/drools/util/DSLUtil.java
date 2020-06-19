package az.xpay.xweb.drools.util;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.File;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/18 10:33
 */
public class DSLUtil {

    public static void fileRules(File file, Object rules){

        try {
            KieServices kieServices = KieServices.Factory.get();
            KieFileSystem kfs = kieServices.newKieFileSystem();
            Resource resource = kieServices.getResources().newFileSystemResource(file);
            file(rules, kieServices, kfs, resource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void file(Object rules, KieServices kieServices, KieFileSystem kfs, Resource resource) throws Exception{

        resource.setResourceType(ResourceType.DRL);
        kfs.write(resource);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        if(kieBuilder.getResults().getMessages(Message.Level.ERROR).size() > 0){
            throw new Exception();
        }

        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieBase kBase = kieContainer.getKieBase();
        KieSession kieSession = kBase.newKieSession();
        kieSession.insert(rules);
        kieSession.fireAllRules();

    }

}
