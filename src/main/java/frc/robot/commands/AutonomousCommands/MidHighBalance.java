package frc.robot.commands.AutonomousCommands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateRightCommand;
import frc.robot.subsystems.SwerveModule;
import frc.robot.subsystems.SwerveSubsystem;

public class MidHighBalance extends SequentialCommandGroup {

  private Timer autoTimer;

  private BooleanSupplier endCondition;

  // Start at middle position
  // Place pre-load at high
  // Balance onto charge station

  public MidHighBalance(SwerveSubsystem swerve) {

    autoTimer = new Timer();

    endCondition = () -> (autoTimer.get() > 14.5);



    Commands.runOnce( () -> new DriveBackwardCommand(swerve, 0).andThen(new DriveForwardCommand(swerve, 0)), swerve);

    Commands.startEnd( () -> new DriveBackwardCommand(swerve, 0).andThen( () -> new RotateRightCommand(swerve, 0), swerve), () -> new DriveForwardCommand(swerve, 0), swerve);
    
    new RunCommand( () -> new DriveBackwardCommand(swerve, 0), swerve);

    new DriveBackwardCommand(swerve, 0).until(null);

    new SequentialCommandGroup(null).until(endCondition);
    
    addCommands( 


    );

  }
}
