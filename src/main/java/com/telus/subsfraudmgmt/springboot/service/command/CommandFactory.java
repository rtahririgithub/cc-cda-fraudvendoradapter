package com.telus.subsfraudmgmt.springboot.service.command;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
	
	@Autowired
	private UpdateAppDispositionCommand updateAppDispositionCommand;
	
	@Autowired
	private FraudPredictionCommand fraudPredictionCommand;
	
	@Autowired
	private FraudCheckCommand fraudCheckCommand;
	
	@Autowired
	private CreateFraudFileCommand createFraudFileCommand;
	
	@Autowired
	private UpdateFraudFileCommand updateFraudFileCommand;
	
	@Autowired
	private DeleteFraudFileCommand deleteFraudFileCommand;
	
	@Autowired
	private UpdateCaseDispositionCommand updateCaseDispositionCommand;
	
	@Autowired
	private TelusPubCommand telusPubCommand;
	
	
    
	private Map<String, Object> maps = new HashMap<>();

	/**
	 * @param <T>          the generics parameter type
	 * @param commandClass the instance of Class representing class in runtime.
	 * @return the object with specified type
	 */
	public <T> T getCommand(Class<T> commandClass) {
		return (T) maps.get(commandClass.getName());
	}
	
	/**
	 * Invoked by spring boot to build map for all commands that it provides
	 * <p>Do not remove
	 */
	@PostConstruct
	public void populateMap() {
		maps.put(UpdateAppDispositionCommand.class.getName(), updateAppDispositionCommand);
		maps.put(FraudPredictionCommand.class.getName(), fraudPredictionCommand);
		maps.put(FraudCheckCommand.class.getName(), fraudCheckCommand);
		maps.put(CreateFraudFileCommand.class.getName(), createFraudFileCommand);
		maps.put(UpdateFraudFileCommand.class.getName(), updateFraudFileCommand);
		maps.put(DeleteFraudFileCommand.class.getName(), deleteFraudFileCommand);	
		maps.put(UpdateCaseDispositionCommand.class.getName(), updateCaseDispositionCommand);	
		maps.put(TelusPubCommand.class.getName(), telusPubCommand);
		
	}
	
}
