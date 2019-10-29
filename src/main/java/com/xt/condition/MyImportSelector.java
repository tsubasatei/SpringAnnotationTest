package com.xt.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值，就是导入容器中的组件的全类名
     * @param annotationMetadata ：当前标注 @Import 注解的类的所有注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.xt.bean.Blue", "com.xt.bean.Yellow"};
    }
}
