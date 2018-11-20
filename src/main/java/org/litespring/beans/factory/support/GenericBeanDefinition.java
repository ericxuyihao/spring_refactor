package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {

	// 对应xml文件的id
	private String id;
	// 对应xml文件的class属性
	private String beanClassName;

	private boolean singleton=true;
	private boolean prototype=false;
	private String scope=SCOPE_DEFAULT;
	public GenericBeanDefinition(String id, String beanClassName) {
		this.id = id;
		this.beanClassName = beanClassName;
	}

    public boolean isSigleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
            this.scope=scope;
            this.singleton=SCOPE_SINGLETON.equals(scope)||SCOPE_DEFAULT.equals(scope);
            this.prototype=SCOPE_PROTOTYPE.endsWith(scope);
    }

    public String getBeanClassName() {
		
		return this.beanClassName;
	}
	
	
	

}
