package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by joshuasmith on 1/20/18.
 */

@TeleOp(name="DriveTestLift", group = "tests")
public class MecanumWithLift extends OpMode {
    //This just declares names for motors. You cannot drive them until you connect them to the
    //hardware map
    public DcMotor mFrontLeftMotor;
    public DcMotor mFrontRightMotor;
    public DcMotor mBackRightMotor;
    public DcMotor mBackLeftMotor;
    public DcMotor motorArm;
    public Servo servoClawLeftTop;
    public Servo servoClawRightTop;
    public Servo servoClawLeftBottom;
    public Servo servoClawRightBottom;
    public DcMotor motorSpin;
    private boolean opentop;
    private boolean lastlefttriggertop;
    private boolean openbottom;
    private boolean lastrighttriggerbottom;
    private boolean armspin;
    private boolean lastdpadrightspin;

    public void init(){
        //The code below allows the rev hubs to find the motors. When you configure the robot,
        //make sure you configure the motors as neverest 40's, and make sure you name the motors
        //as the green words in the quotes below(Capitalization matters). Ex. FrontLeft
        mFrontLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeft");
        mFrontRightMotor = hardwareMap.get(DcMotor.class, "FrontRight");
        mBackLeftMotor = hardwareMap.get(DcMotor.class, "BackLeft");
        mBackRightMotor = hardwareMap.get(DcMotor.class, "BackRight");
        motorArm = hardwareMap.get(DcMotor.class, "armMotor");
        servoClawLeftBottom = hardwareMap.get(Servo.class, "leftclawServoBottom");
        servoClawLeftTop = hardwareMap.get(Servo.class, "leftclawServoTop");
        servoClawRightBottom = hardwareMap.get(Servo.class, "rightclawServoBottom");
        servoClawRightTop = hardwareMap.get(Servo.class, "rightclawServoTop");
        motorSpin = hardwareMap.get(DcMotor.class, "spinMotor");
        //motorSpin.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //motorSpin.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //then we reverse two motors so they all spin forward when given a positive value
        mBackLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        mFrontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);



        //this makes it so that when the motors have a speed of 0, they will not just drift
        //and slide. Rather, they will brake and come to a stop
        mFrontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mFrontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mBackLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mBackRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void loop() {
        float UY = gamepad2.y ? 1.0f : 0.0f;
        float DA = gamepad2.a ? 1.0f : 0.0f;

        drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

        arm();

        spin();

        if (gamepad2.left_stick_y > 0) {
            motorSpin.setPower(1);
        }


        if (gamepad2.y) {
            motorArm.setPower(UY);
        } else if (gamepad2.a) {
            motorArm.setPower(-DA);
        } else {
            motorArm.setPower(0.0);
        }
    }

    public void spin() {

        if (gamepad2.dpad_right && !lastdpadrightspin) {

            if (armspin) {
                motorSpin.setTargetPosition(560);
                motorSpin.setPower(0);
                armspin = false;
            }
            else {
                motorSpin.setTargetPosition(0);
                motorSpin.setPower(0);
                armspin = true;
            }
        }
        lastdpadrightspin = gamepad2.dpad_right;
    }



    public void arm(){

        if (gamepad2.left_trigger >0 && !lastlefttriggertop) {

            if (opentop) {
                servoClawLeftTop.setPosition(0);
                servoClawRightTop.setPosition(1);
                opentop = false;
            } else {
                servoClawLeftTop.setPosition(1);
                servoClawRightTop.setPosition(0);
                opentop = true;
            }
        }

        if (gamepad2.right_trigger >0 && !lastrighttriggerbottom) {
            if (openbottom) {
                servoClawLeftBottom.setPosition(1);
                servoClawRightBottom.setPosition(0);
                openbottom = false;
            } else {
                servoClawLeftBottom.setPosition(0);
                servoClawRightBottom.setPosition(1);
                openbottom = true;
            }
        }

    lastrighttriggerbottom = gamepad2.right_trigger >0;
    lastlefttriggertop = gamepad2.left_trigger >0;

    }



    //this function, given joystick values for the x axis movement, y axis movement, and rotation,
    //will translate it into 4 motors values and set powers to the motors
    public void drive(double x, double y, double r){
        //the if statements below make it so there is a "deadzone" in the driving
        //where the robot wont move at all. Makes stopping the robot easier.


        if( Math.abs(y) <= 0.15){
            y = 0;
        }
        if( Math.abs(x) <= 0.15){
            x = 0;
        }
        if( Math.abs(r) <= 0.15){
            r = 0;
        }

        //this creates 4 variables that hold the motor values, and calculates their power
        //given the x, y, and rotation values.
        double FRPower = y-x-r;
        double FLPower = y+x+r;
        double BLPower = y-x+r;
        double BRPower = y+x-r;

        //the if statements below save the greatest power value
        double max = Math.abs(FLPower);
        if(Math.abs(FRPower)>max) max = Math.abs(FRPower);
        if(Math.abs(BRPower)>max) max = Math.abs(BRPower);
        if(Math.abs(BLPower)>max) max = Math.abs(BLPower);

        //sometimes your maximum value will be greater than 1. This is bad because the
        //motors can only drive at a maximum speed of 1. That means if the max value is
        //greater than 1, we must scale all of the values to be <= 1
        if(max > 1){
            FLPower /= max;
            FRPower /= max;
            BRPower /= max;
            BLPower /= max;
        }

        //after we have calculated all of the motor values, these final 4 statements
        //actually set the motors to move at their respective speeds
        mFrontLeftMotor.setPower(FLPower);
        mFrontRightMotor.setPower(FRPower);
        mBackRightMotor.setPower(BRPower);
        mBackLeftMotor.setPower(BLPower);

    }
}
