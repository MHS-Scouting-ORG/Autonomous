// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateLeftCommand;
import frc.robot.subsystems.SwerveSubsystem;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase Auto(SwerveSubsystem swerve) {
    return Commands.sequence(
      new DriveForwardCommand(swerve, 0),
      // (Elevator Up, arm out, drop game-piece [Use parallel command group for elevator up and arm out])
      // (Bring arm in, elevator down [Use parallel])
      new DriveBackwardCommand(swerve, 0),
      new RotateLeftCommand(swerve, 180),
      // (Brings arm out, elevator down, pick up a game-piece []Use parallel command group for elevator down and arm out)
      new DriveBackwardCommand(swerve, 0),
      new IncrementBalanceCommand(swerve)

    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
