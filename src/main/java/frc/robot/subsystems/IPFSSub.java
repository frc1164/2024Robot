// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;

import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.PickupConstants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkLowLevel.MotorType;




public class IPFSSub extends SubsystemBase {
  private final CANSparkMax TLShooterMotor;
  private final CANSparkMax Feeder;
  private final CANSparkMax TRShooterMotor;
  private final CANSparkMax BLShooterMotor;
  private final CANSparkMax BRShooterMotor;
  private final CANSparkMax IntakeMotor;
  
  
  private final RelativeEncoder TLEncoder; 
  private final RelativeEncoder TREncoder;
  private final RelativeEncoder BLEncoder;
  private final RelativeEncoder BREncoder;

  public final DigitalInput PickupSensor;  


  /** Creates a new IPFSSub. */
  public IPFSSub() {
  TLShooterMotor = new CANSparkMax(ShooterConstants.TLShooterMotor, MotorType.kBrushless);
  TRShooterMotor = new CANSparkMax(ShooterConstants.TRShooterMotor, MotorType.kBrushless);
  TRShooterMotor.setInverted(true);
  BLShooterMotor = new CANSparkMax(ShooterConstants.BLShooterMotor, MotorType.kBrushless);
  BRShooterMotor = new CANSparkMax(ShooterConstants.BRShooterMotor, MotorType.kBrushless);
  BRShooterMotor.setInverted(true);
  Feeder = new CANSparkMax(PickupConstants.PFeederMotor, MotorType.kBrushless);
  IntakeMotor = new CANSparkMax(PickupConstants.PickupMotor, MotorType.kBrushless);
  TLShooterMotor.setIdleMode(IdleMode.kBrake);
  TRShooterMotor.setIdleMode(IdleMode.kBrake);
  BLShooterMotor.setIdleMode(IdleMode.kBrake);
  BRShooterMotor.setIdleMode(IdleMode.kBrake);
  Feeder.setIdleMode(IdleMode.kBrake);
  IntakeMotor.setIdleMode(IdleMode.kBrake);
  

  
  PickupSensor = new DigitalInput (1);

  TLEncoder = TLShooterMotor.getEncoder();
  TREncoder = TRShooterMotor.getEncoder();
  BLEncoder = BLShooterMotor.getEncoder();
  BREncoder = BRShooterMotor.getEncoder();

  }

  public double TLVelocity() {
    return TLEncoder.getVelocity();
  }
  
  public double TRVelocity() {
    return TREncoder.getVelocity();
  }

  public double BLVelocity() {
    return BLEncoder.getVelocity();
  }
  
  public double BRVelocity() {
    return BREncoder.getVelocity();
  }

  public void Shoot(double speed) {
    //left shooter motor temporarily off due to spark max issues
    TLShooterMotor.set(speed);
    TRShooterMotor.set(speed);
    BLShooterMotor.set(speed);
    BRShooterMotor.set(speed);
  }
  
  public void Feed(double speed) {
    Feeder.set(speed);
  }

  public void Intake(double speed) {
   IntakeMotor.set(speed);
  }


  public boolean haveNote() {
    return PickupSensor.get();
  }

    @Override

  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("PickupSensor", PickupSensor.get());

  }
}
