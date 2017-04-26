 /**
     * 下行parser的结果的包装，为了和之前
     * 的ｔａｐｉ返回数据格式一样
     * @param result　
     * @return
     */
    private String packageRspCmdData(ParsersEnum parsersEnum,String result){
        //获取执行的指令
        String ParseCommand=parsersEnum.getReqData().getCommand();
        JSONObject jo=JSON.parseObject(result);
        jo.put("TransactionID","");
        jo.put("ParseCommand",ParseCommand);
        result=jo.toJSONString();
        result="<Response>"+result+"</Response>";
        return result;
    }
    
    
    
