package com.dpavlenko.command;

//concrete command
//New code after refactoring OnCommand
public class ToggleCommand implements Command {

	private Light light;
	
	public ToggleCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.toggle();
	}
}