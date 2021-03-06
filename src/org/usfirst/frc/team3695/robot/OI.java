package org.usfirst.frc.team3695.robot;

import org.usfirst.frc.team3695.robot.commands.CommandDistance;
import org.usfirst.frc.team3695.robot.commands.CommandSecondaryDistance;
import org.usfirst.frc.team3695.robot.commands.CommandSecondaryDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driveStick = new Joystick(Constants.DRIVE_JOYSTICK);
	private Joystick operatorStick = new Joystick(Constants.OPERATOR_JOYSTICK);
	
	public OI() {
		//SmartDash
		SmartDashboard.putData("Move 1 Stephen (slow)", new CommandDistance(0.25,1));
		SmartDashboard.putData("Move 1 Stephen (fast)", new CommandDistance(1,1));
		SmartDashboard.putData("Move 1 Stephen (6 wheel)", new CommandSecondaryDistance(1,1));
		
		//6 Wheel Drive Button ('Obstacle Button')
		Button doObstacleMagically = new JoystickButton(driveStick, Constants.ENABLE_6WHEEL_DRIVE);
		doObstacleMagically.whileActive(new CommandSecondaryDrive());
		
		//Buttons
		//Example button: Button enableHighBeams = new JoystickButton(driveStick, Constants.ENABLE_HIGH_BEAMS);
		//Example button: enableHighBeams.whenPressed(new ExampleCommand());
	}
	
	/**
	 * Gets the Joystick for driving the robot.
	 * @return Joystick driveStick
	 */
	public Joystick getDriveStick() {
		return driveStick;
	}
	
	/**
	 * Gets the Joystick for whatever the operator needs to do (move ball up/down etc.)
	 * @return Joystick operatorStick.
	 */
	public Joystick getOperatorStick() {
		return operatorStick;
	}
}

