package io.worm.enitiy;
/**
 *
 * 自动将greeting封装成json
 *
 * */
public class Greeting {
    private final long id;//id字段是问候语的唯一标示符
    private final String content;//表示问候语句
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
