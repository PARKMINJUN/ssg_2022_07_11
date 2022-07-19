package com.ll.exam;

public class Rq {
    private String path;
    private String[] queryStrBits;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?", 2);

        this.path = cmdBits[0];

        if (cmdBits.length == 2) {
            this.queryStrBits = cmdBits[1].split("&");
        }
    }

    public String getPath() {
        return path;
    }

    public int getIntParam(String paramName, int defaultValue) {
        if ( queryStrBits == null )
        {
            return defaultValue;
        }

        for ( String queryStrBit : queryStrBits ) {
            String[] queryStrBitBits = queryStrBit.split("=", 2);
            String paramName_ = queryStrBitBits[0];
            String paramValue = queryStrBitBits[1];

            if ( paramName.equals(paramName_) ) {
                return Integer.parseInt(paramValue);
            }
        }

        return defaultValue;
    }
}