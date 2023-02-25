package frc.robot.commands.TestingCommands;

import org.ejml.equation.Function;

import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SwerveSubsystem;
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PantherBots extends SequentialCommandGroup {

  public PantherBots(SwerveSubsystem swerve) {

    addCommands(
      
      new FunctionalCommand(
        //init
        () -> swerve.autoYaw = swerve.getAngle(), 

        //on execute 
        null, 

        //on end
        null, 

        //is finished 
        null, 

        //add requirements
        null)
    );
  }
}
