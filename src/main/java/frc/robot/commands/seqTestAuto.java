// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateLeftCommand;
import frc.robot.commands.MovementCommands.StrafeRightCommand;
import frc.robot.subsystems.SwerveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class seqTestAuto extends SequentialCommandGroup {
  /** Creates a new seqTestAuto. */
  public seqTestAuto(SwerveSubsystem swerve) {
    Timer autoTimer = new Timer(); 
    autoTimer.reset();
    autoTimer.start();

    if (autoTimer.get() > 5) {
      addCommands(new Lock(swerve));
      autoTimer.stop();
    } else {
      addCommands(
        new DriveForwardCommand(swerve), 

        new DriveBackwardCommand(swerve), 

        new RotateLeftCommand(swerve), 

        new StrafeRightCommand(swerve)

      );
    }

    SmartDashboard.putNumber("auto timer", autoTimer.get()); 
  }
}
