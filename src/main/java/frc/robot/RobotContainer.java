package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriverControl;
import frc.robot.commands.IncrementBalanceCommand;
import frc.robot.commands.AutonomousCommands.MidHighBalance;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.subsystems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriverControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import com.pathplanner.lib.commands.FollowPathWithEvents;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.StrafeLeftCommand;
import frc.robot.commands.MovementCommands.RotateRightCommand;

public class RobotContainer {

  private final SwerveSubsystem swerve = new SwerveSubsystem();
  private final XboxController m_Controller =
      new XboxController(0); 

  public RobotContainer() {
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



  /////////////////////////////////////
  //                                 //
  //                                 //
  //                                 //
  //    TESTING PATH PLANNER HERE    //
  //                                 //
  //                                 //
  /////////////////////////////////////

  private Command getAutonomousCommand;

  // Wiki Method
  public void SwerveAutoBuilderAutonomous(){

    // Creates a new Translation2d object
    Translation2d translation2d = new Translation2d( );

    // Creates a new Pose2d object
    Pose2d pose2d = new Pose2d();

    // This creates a new has map for events within the PathPlanner map
    HashMap<String, Command> AUTO_EVENT_MAP = new HashMap<>();

    // Variable that loads the path goup
    ArrayList<PathPlannerTrajectory> autoPathTest = (ArrayList<PathPlannerTrajectory>) PathPlanner.loadPathGroup("autoPathTest", 0.1, 0.2);

    // Creates Autonomous
    SwerveAutoBuilder autoBuilder = new SwerveAutoBuilder(null, null, null, null, null, null, null);

    getAutonomousCommand = autoBuilder.fullAuto(autoPathTest);
  }


  /*** No longer using this, the FollowPath command doesn't seem to work  ***/
  // // Video Method
  // public Command configureAutoCommands(){

  //   // Creates a new Translation2d object
  //   Translation2d translation2d = new Translation2d( );

  //   // Creates a new Pose2d object
  //   Pose2d pose2d = new Pose2d();

  //   // This creates a new has map for events within the PathPlanner map
  //   HashMap<String, Command> AUTO_EVENT_MAP = new HashMap<>();
  //   AUTO_EVENT_MAP.put("event1", new InstantCommand(() -> SmartDashboard.putString("Current Marker", "Marker 1 Passed")));

  //   // Variable that loads the path goup
  //   ArrayList<PathPlannerTrajectory> autoPathTest = (ArrayList<PathPlannerTrajectory>) PathPlanner.loadPathGroup("autoPathTest", 0.1, 0.2);
  // }
  

  public Command getAutonomousCommand() {
    return getAutonomousCommand;
  }

  






}
