/*
 *  Copyright 2011 The MyBatis Team
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.sample;

import java.util.List;

import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;

public class MyJavaFormatter implements JavaFormatter {
    protected Context context;
    
    public String getFormattedContent(CompilationUnit compilationUnit) {
    	if(compilationUnit instanceof TopLevelClass){
    		TopLevelClass top = (TopLevelClass) compilationUnit;
    		//添加类注解
    		top.addAnnotation("@Model");
    		top.addFileCommentLine("注释1");
    		top.addFileCommentLine("注释2");
    		//添加import或static import
    		top.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.type.JdbcType"));
    		top.addStaticImport("java.lang.*");
    		List<Method> methods = top.getMethods();
    		List<Field> fields = top.getFields();
    		//同理对方法或属性添加注解
    		methods.get(0).addAnnotation("");
    		fields.get(0).addAnnotation("");
    	} else if(compilationUnit instanceof Interface){
    		TopLevelClass top = (TopLevelClass) compilationUnit;
    		//添加类注解
    		top.addAnnotation("@Interface");
    		top.addFileCommentLine("注释");
    		//添加import或static import
    		top.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.type.JdbcType"));
    		top.addStaticImport("java.lang.*");
    		List<Method> methods = top.getMethods();
    		List<Field> fields = top.getFields();
    		//同理对方法或属性添加注解
    		methods.get(0).addAnnotation("");
    		fields.get(0).addAnnotation("");
    	}
        return compilationUnit.getFormattedContent();
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
