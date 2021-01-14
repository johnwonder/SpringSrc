package com.john.event;

import org.springframework.beans.factory.parsing.*;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/12
 */
public class MyReaderEventListener implements ReaderEventListener {

	@Override
	public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {
		System.out.println("defaultsDefinition trigger");
	}

	@Override
	public void aliasRegistered(AliasDefinition aliasDefinition) {
		System.out.println("aliasRegisted trigger");
	}

	@Override
	public void componentRegistered(ComponentDefinition componentDefinition) {


		System.out.println(componentDefinition.getName() + " componentDefinition trigger");
	}

	@Override
	public void importProcessed(ImportDefinition importDefinition) {
		System.out.println("importProcessed trigger");
	}
}
