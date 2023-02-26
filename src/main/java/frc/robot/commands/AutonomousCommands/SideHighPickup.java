package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.DriveCommands.DriveBackwardCommand;
import frc.robot.commands.DriveCommands.DriveForwardCommand;
import frc.robot.commands.DriveCommands.RotateLeftCommand;
import frc.robot.commands.SequentialElevatorPivotCommands.Tucked;
import frc.robot.commands.SequentialElevatorPivotCommands.LowPickup;
import frc.robot.commands.SequentialElevatorPivotCommands.TopNode;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class SideHighPickup extends SequentialCommandGroup {

  public SideHighPickup(SwerveSubsystem swerve, ClawSubsystem claw, PivotSubsystem pivot, ElevatorSubsystem elevator) {

    addCommands(

      new TopNode(pivot, elevator),

      new DriveForwardCommand(swerve, 10),

      new Claw(claw),

      new DriveBackwardCommand(swerve, 10),
      
      new LowPickup(pivot, elevator),

      new RotateLeftCommand(swerve, 180),

      new DriveForwardCommand(swerve, 100),

      new Claw(claw)
    );
  }
}
