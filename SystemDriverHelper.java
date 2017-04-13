
public class SystemDriverHelper {
    /**
     * windows的64位系统
     * @param sce
     */
    private void loadWin64Driver(ServletContextEvent sce) {
        try {
            System.load(new File(sce.getServletContext().getRealPath("")).getAbsolutePath()
                    + "/WEB-INF/lib/sigar-amd64-winnt.dll");
            System.out.println(">>>>加载windows64驱动 成功！！");
        }catch(Error e){
            Log.error(">>>>该系统不能加载windows64驱动",e.getMessage());
        }
    }
    /**
     * linux64位
     * @param sce
     */
    private void loadLinux64Driver(ServletContextEvent sce) {
        try {
            System.load(new File(sce.getServletContext().getRealPath("")).getAbsolutePath()
                    + "/WEB-INF/lib/libsigar-amd64-linux.so");
            Log.info(">>>>加载Linux64驱动 成功！！");
        }catch(Error e){
            Log.error(">>>>该系统不能加载Linux64驱动", e.getMessage());
        }
    }

    /**
     * linuxx86系统
     * @param sce
     */
    private void loadLinux86Driver(ServletContextEvent sce) {
        try {
            System.load(new File(sce.getServletContext().getRealPath("")).getAbsolutePath()
                    + "/WEB-INF/lib/libsigar-x86-linux.so");
            Log.info(">>>>加载Linuxx86驱动 成功！！");
        }catch(Error e){
            Log.error(">>>>该系统不能加载Linuxx86驱动", e.getMessage());
        }
    }

    public static void main(String[] args){
        String soName=System.getProperty("os.name");
        String osBit = System.getProperty("os.arch");
        System.out.println(soName+"-"+osBit);   //输出结果：Linux-amd64   
    }
}
