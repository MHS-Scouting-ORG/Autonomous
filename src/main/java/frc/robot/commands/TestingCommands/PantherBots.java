package frc.robot.commands.TestingCommands;

import org.ejml.equation.Function;

import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateLeftCommand;
import frc.robot.commands.MovementCommands.StrafeRightCommand;
import frc.robot.subsystems.SwerveSubsystem;
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PantherBots extends SequentialCommandGroup {

  public PantherBots(SwerveSubsystem swerve) {

    addCommands(
      
    new DriveForwardCommand(swerve), 

    new DriveBackwardCommand(swerve), 

    new RotateLeftCommand(swerve), 

    new StrafeRightCommand(swerve)
    );
  }
}
