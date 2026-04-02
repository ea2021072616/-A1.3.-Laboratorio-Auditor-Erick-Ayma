package org.phprpc.spring.remoting;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.phprpc.PHPRPC_Server;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.remoting.support.RemoteExporter;
import org.springframework.web.HttpRequestHandler;
/* loaded from: classes2.dex */
public class PHPRPC_Exporter extends RemoteExporter implements InitializingBean, HttpRequestHandler {
    private Map aliases;

    public void afterPropertiesSet() throws Exception {
        prepare();
    }

    public void prepare() {
        checkService();
        checkServiceInterface();
        Object service = getService();
        Class serviceInterface = getServiceInterface();
        if (this.aliases != null && this.aliases.size() > 0) {
            String[] allFunctions = PHPRPC_Server.getAllFunctions(serviceInterface);
            for (String str : this.aliases.keySet()) {
                PHPRPC_Server.addGlobal(str, service, serviceInterface, (String) this.aliases.get(str));
                int i = 0;
                while (true) {
                    if (i < allFunctions.length) {
                        if (!allFunctions[i].equals(str.toLowerCase())) {
                            i++;
                        } else {
                            allFunctions[i] = "";
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < allFunctions.length; i2++) {
                if (!allFunctions[i2].equals("")) {
                    PHPRPC_Server.addGlobal(new String[]{allFunctions[i2]}, service, serviceInterface, (String[]) null);
                }
            }
            return;
        }
        PHPRPC_Server.addGlobal(service, serviceInterface);
    }

    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        new PHPRPC_Server().start(httpServletRequest, httpServletResponse);
    }

    public void setAliases(Map map) {
        this.aliases = map;
    }
}
