package com.apecircle.easytranslib.method;

public enum SheetEnum {
    Default("values", "默认/Default"),
    CN_ZH("values-zh-rCN", "简体中文/Chinese"),
    CN_HK("values-zh-rHK", "繁体中文-香港"),
    CN_TW("values-zh-rTW", "繁体中文-台湾"),
    EN("values-en", "英语/English"),
    Czech("values-cs-rCZ", "捷克/Czech"),
    Danish("values-da-rDK", "丹麦语/Danish"),
    Dutch("values-nl", "荷兰语/Dutch"),
    Spanish("values-es", "西班牙/Spanish"),
    Finnish("values-fi-rFI", "芬兰语/Finnish"),
    Portuguese("values-pt", "葡萄牙语/Portuguese"),
    French("values-fr", "法语/French"),
    Deutsch("values-de-rDE", "德语/Deutsch"),
    Greek("values-el-rGR", "希腊语/Greek"),
    Italian("values-it-rIT", "意大利语/Italian"),
    Japanese("values-ja", "日语/Japanese"),
    Norwegian("values-nb-rNO", "挪威语/Norwegian"),
    Polish("values-pl-rPL", "波兰语/Polish"),
    Romanian("values-ro-rRO", "罗马尼亚语/Romanian"),
    Russian("values-ru-rRU", "俄语/Russian"),
    Swedish("values-sv-rSE", "瑞典语/Swedish"),
    Turkish("values-tr-rTR", "土耳其语/Turkish"),
    Arabic("values-ar", "阿拉伯语/Arabic"),
    Hungarian("values-hu-rHU", "匈牙利语/Hungarian"),
    Thai("values-th-rTH", "泰语/Thai"),
    Persian("values-fa", "波斯语/Persian"),
    Vietnamese("values-vi-rVN", "越南语/Vietnamese"),
    Korean("values-ko-rKR", "韩语/Korean");

    private String valueFileName;//文件夹名称
    private String title;        //对应excel中的标题

    SheetEnum(String valueFileName, String title) {
        this.valueFileName = valueFileName;
        this.title = title;
    }

    public String getValueFileName() {
        return valueFileName;
    }

    public String getTitle() {
        return title;
    }
}
