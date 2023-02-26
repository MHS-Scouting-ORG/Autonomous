package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmCommands.HighAutoPositionParallel;
import frc.robot.commands.ArmCommands.Tucked;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class Hybrid extends SequentialCommandGroup {

  public Hybrid(SwerveSubsystem swerve, ClawSubsystem claw, PivotSubsystem pivot, ElevatorSubsystem elevator)  {

    //SCORE CONE IN HYBRID GOAL 
    addCommands(
      // Arm in hybrid goal position (pivot out, elevator down) 
      

      // Move forward 
      new DriveForwardCommand(swerve, 100), 

      // Open claw 
      new Claw(claw),

      // Move backward
      new DriveBackwardCommand(swerve, 100),

      // Arm in resting position (pivot in, elevator down) 
      new Tucked().getCommand(pivot, elevator)

    );
  }
}
