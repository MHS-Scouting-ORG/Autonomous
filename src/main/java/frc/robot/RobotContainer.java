package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriverControl;
import frc.robot.commands.IncrementBalanceCommand;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateLeftCommand;
import frc.robot.commands.MovementCommands.StrafeRightCommand;
import frc.robot.subsystems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriverControl;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {

  private final SwerveSubsystem swerve = new SwerveSubsystem();
  private final XboxController m_Controller = new XboxController(0); 

  public RobotContainer() {
    /* * * Driver Control Default * * */
    swerve.setDefaultCommand(new DriverControl(swerve, 
    () -> -m_Controller.getLeftY(), 
    () -> -m_Controller.getLeftX(),
    () -> -m_Controller.getRightX(), 
    () -> m_Controller.getRightBumper()));

    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(m_Controller, 1).onTrue(new IncrementBalanceCommand(swerve)); 
    new JoystickButton(m_Controller, 2).onTrue(new InstantCommand(() -> swerve.resetNavx())); 
  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      
      new DriveForwardCommand(swerve, 10), 

      new DriveBackwardCommand(swerve, 10) /*, 

      new RotateLeftCommand(swerve, 180), 

      new StrafeRightCommand(swerve, 10) */
    );
  }
}
