package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.AutoConsts;
import frc.robot.Constants.AutoConsts;
import frc.robot.Constants.SwerveConsts;

public class SwerveSubsystem extends SubsystemBase {
    private SwerveModule frontLeft;
    private SwerveModule backLeft;
    private SwerveModule backRight;
    private SwerveModule frontRight;
    public double autoYaw; 

    private SwerveModuleState states;

    private AHRS navx;

  /////////////////////
  //   CONSTRUCTOR   //
  /////////////////////

    public SwerveSubsystem() {
        frontLeft = new SwerveModule(SwerveConsts.FL_turningMotorPort, SwerveConsts.FL_driveMotorPort, 
            SwerveConsts.FL_absoluteEncoderPort, SwerveConsts.FL_offset , false, true, true);
        
        backLeft = new SwerveModule(SwerveConsts.BL_turningMotorPort, SwerveConsts.BL_driveMotorPort, 
            SwerveConsts.BL_absoluteEncoderPort, SwerveConsts.BL_offset , false, true, true);

        backRight = new SwerveModule(SwerveConsts.BR_turningMotorPort, SwerveConsts.BR_driveMotorPort, 
            SwerveConsts.BR_absoluteEncoderPort, SwerveConsts.BR_offset , false, true, true);

        frontRight = new SwerveModule(SwerveConsts.FR_turningMotorPort, SwerveConsts.FR_driveMotorPort, 
            SwerveConsts.FR_absoluteEncoderPort, SwerveConsts.FR_offset , false, true, true);

        navx = new AHRS(SPI.Port.kMXP);

        navx.zeroYaw();
    }

  /////////////////////
  //  RESET METHODS  //
  /////////////////////

    public void resetNavx() {
        navx.zeroYaw();
    }

    public void resetEnc(){
        frontLeft.resetEncoders();
        backLeft.resetEncoders();
        backRight.resetEncoders();
        frontRight.resetEncoders();
    }

  /////////////////////
  //   GET METHODS   //
  /////////////////////

    public double getEnc() {
        return frontLeft.getDrivePosition() * 10; 
    }

    //returns yaw in degrees, 0-360
    public double getYawAngle(){
        return ( /*navx.getYaw()*/ navx.getAngle() % 360 );
    }

    //returns yaw in degrees, number line form 
    public double getAngle(){
        return navx.getAngle(); 
    }

    //MAKE NAVX OFFSET 
    //returns roll in degrees 
    public double getRoll() {
        return navx.getRoll()-3; 
    }

    //returns robot's rotation (yaw) in radians 
    public Rotation2d getRobotRotation(){
      return new Rotation2d(Math.toRadians(navx.getYaw()));
    }

    //returns robot's rotation (yaw) in degrees
    public Rotation2d getRotation2d() {
        return Rotation2d.fromDegrees(getYawAngle());
    } 

  /////////////////////
  //   SET MODULES   //
  /////////////////////

    //stop modules  
    public void stopModules() {
        frontLeft.stop();
        backLeft.stop();
        backRight.stop();
        frontRight.stop();
    }

    //sets the modules to a certain desired state (used in DriverControl)
    public void setModuleStates(SwerveModuleState[] desiredStates) {
        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, SwerveConsts.maxSpeed_mps);
        frontLeft.setDesiredState(desiredStates[0]);
        backLeft.setDesiredState(desiredStates[1]);
        backRight.setDesiredState(desiredStates[2]);
        frontRight.setDesiredState(desiredStates[3]);
    }

    //lock method for Charge Station 
    //wheels in X-formation so they don't roll 
    public void lock(){
        SwerveModuleState fl = new SwerveModuleState(0.0, new Rotation2d(Math.toRadians(45)));
        SwerveModuleState bl = new SwerveModuleState(0.0, new Rotation2d(Math.toRadians(-45)));
        SwerveModuleState br = new SwerveModuleState(0.0, new Rotation2d(Math.toRadians(45)));
        SwerveModuleState fr = new SwerveModuleState(0.0, new Rotation2d(Math.toRadians(-45)));

        frontLeft.setAngle(fl);
        backLeft.setAngle(bl);
        backRight.setAngle(br);
        frontRight.setAngle(fr);
    }

  ///////////////////////////
  //   AUTONOMOUS BASICS   //
  ///////////////////////////

    public void driveForward(double desiredEnc){
        if (getEnc() >= desiredEnc) {
            stopModules();
        } else {
            SwerveModuleState[] moduleStates = SwerveConsts.driveKinematics.toSwerveModuleStates(new ChassisSpeeds(AutoConsts.driveTranslationSpeed, 0, 0));
            setModuleStates(moduleStates);
        }
    }

    public void driveBackward(double desiredEnc){
        if (getEnc() <= -desiredEnc) {
            stopModules();
        } else {
            SwerveModuleState[] moduleStates = SwerveConsts.driveKinematics.toSwerveModuleStates(new ChassisSpeeds(-AutoConsts.driveTranslationSpeed, 0, 0));
            setModuleStates(moduleStates);
        }
    }

    public void strafeLeft(double desiredEnc){
        if (getEnc() >= desiredEnc) {
            stopModules();
        } else {
            SwerveModuleState[] moduleStates = SwerveConsts.driveKinematics.toSwerveModuleStates(new ChassisSpeeds(0, -AutoConsts.driveTranslationSpeed, 0));
            setModuleStates(moduleStates);    
        }
    }

    public void strafeRight(double desiredEnc){
        if (getEnc() <= -desiredEnc) {
            stopModules();
        } else {
            SwerveModuleState[] moduleStates = SwerveConsts.driveKinematics.toSwerveModuleStates(new ChassisSpeeds(0, AutoConsts.driveTranslationSpeed, 0));
            setModuleStates(moduleStates);
        }
    }

    //init autoYaw when you make the FunctionalCommand
    //"() -> swerve.autoYaw = swerve.getAngle()," in init 
    public void rotateLeft(double desiredAngle){ 
        if (getAngle() <= autoYaw - desiredAngle) {
            stopModules();
        } else {
            SwerveModuleState[] moduleStates = SwerveConsts.driveKinematics.toSwerveModuleStates(new ChassisSpeeds(0, 0, -AutoConsts.driveRotationSpeed));
            setModuleStates(moduleStates);
        }
    }

    public void rotateRight(double desiredAngle){
        if (getAngle() >= autoYaw + desiredAngle) {
            stopModules();
        } else {
            SwerveModuleState[] moduleStates = SwerveConsts.driveKinematics.toSwerveModuleStates(new ChassisSpeeds(0, 0, AutoConsts.driveRotationSpeed));
            setModuleStates(moduleStates); 
        }
    }

    //set x, y, and z axes 
    //used in the PID Balance  
    public void pidDrive(double y, double x, double z) {
        SwerveModuleState[] moduleStates = SwerveConsts.driveKinematics.toSwerveModuleStates(new ChassisSpeeds(y, x, z)); 
        setModuleStates(moduleStates);
    }
    
    public void setTank(double lSpeed, double rSpeed){
        frontLeft.setDrivingMotor(lSpeed);
        backLeft.setDrivingMotor(lSpeed);
        backRight.setDrivingMotor(rSpeed);
        frontRight.setDrivingMotor(rSpeed);
    }

    // PERIODIC - runs repeatedly (like periodic from timed robot)
    @Override
    public void periodic() {
    SmartDashboard.putNumber("Robot Yaw", getYawAngle());
    SmartDashboard.putNumber("Robot Pitch", getRoll());
    }
    

}
