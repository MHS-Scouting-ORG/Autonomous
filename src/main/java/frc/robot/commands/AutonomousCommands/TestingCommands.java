package frc.robot.commands.AutonomousCommands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateRightCommand;
import frc.robot.commands.MovementCommands.StrafeLeftCommand;
import frc.robot.subsystems.SwerveSubsystem;

public class TestingCommands extends SequentialCommandGroup {

  private Timer autoTimer;

  private BooleanSupplier endCondition;

  // Start at middle position
  // Place pre-load at high
  // Balance onto charge station

  public TestingCommands(SwerveSubsystem swerve) {

    autoTimer = new Timer();

    endCondition = () -> (autoTimer.get() > 14.5);


    // runOnce command utilizing Commands Class
    Commands.runOnce(

        () -> new DriveBackwardCommand(swerve, 10).andThen(
            
        () -> new DriveForwardCommand(swerve, 10)).andThen(
        
        () -> new RotateRightCommand(swerve, 30)).andThen(
            
        () -> new StrafeLeftCommand(swerve, 10)),
         
    swerve).until(endCondition);


    // startEnd command utilizing Commands Class
    Commands.startEnd(
        
        () -> new DriveForwardCommand(swerve, 10).andThen(

        () -> new DriveBackwardCommand(swerve, 10)).andThen(

        () -> new RotateRightCommand(swerve, 30)).andThen(

        () -> new StrafeLeftCommand(swerve, 10)),
        
        // Run on end
         () -> new InstantCommand( () ->swerve.stopModules()),
    
    swerve).until(endCondition);
    

    // Using sequence utilizing Commands class
    Commands.sequence(
        
    new DriveBackwardCommand(swerve, 10), 
    
    new DriveForwardCommand(swerve, 10), 

    new RotateRightCommand(swerve, 30), 

    new StrafeLeftCommand(swerve, 10)
    
    ).until(endCondition);


    // RunCommand method with andThen on the outside and until
    new RunCommand( 

        () -> new DriveBackwardCommand(swerve, 10).andThen(

        () -> new DriveForwardCommand(swerve, 10)).andThen(
        
        () -> new RotateRightCommand(swerve, 30)).andThen(
            
        () -> new StrafeLeftCommand(swerve, 10)),
        
    swerve).until(endCondition);


    // Sequential Command Group using until method
    new SequentialCommandGroup(
        
        new DriveBackwardCommand(swerve, 10), 
    
        new DriveForwardCommand(swerve, 10), 
    
        new RotateRightCommand(swerve, 30), 
    
        new StrafeLeftCommand(swerve, 10)
    
        // Interrupts after 14.5 seconds have passed
    ).until(endCondition);
    
    addCommands( 


    );

  }
}
