package root.forza.telemetry;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;

public class ForzaApi {
    public static final int PACKET_SIZE = 323;
    private boolean readOK = false;
    DecimalFormat df;

    private boolean isRaceOn;
    private Long timeStampMS;
    private Float engineMaxRpm;
    private Float engineIdleRpm;
    private Float currentEngineRpm;
    private Float accelerationX;
    private Float accelerationY;
    private Float accelerationZ;
    private Float velocityX;
    private Float velocityY;
    private Float velocityZ;
    private Float angularVelocityX;
    private Float angularVelocityY;
    private Float angularVelocityZ;
    private Float yaw;
    private Float pitch;
    private Float roll;
    private Float normalizedSuspensionTravelFrontLeft;
    private Float normalizedSuspensionTravelFrontRight;
    private Float normalizedSuspensionTravelRearLeft;
    private Float normalizedSuspensionTravelRearRight;
    private Float tireSlipRatioFrontLeft;
    private Float tireSlipRatioFrontRight;
    private Float tireSlipRatioRearLeft;
    private Float tireSlipRatioRearRight;
    private Float wheelRotationSpeedFrontLeft;
    private Float wheelRotationSpeedFrontRight;
    private Float wheelRotationSpeedRearLeft;
    private Float wheelRotationSpeedRearRight;
    private Integer wheelOnRumbleStripFrontLeft;
    private Integer wheelOnRumbleStripFrontRight;
    private Integer wheelOnRumbleStripRearLeft;
    private Integer wheelOnRumbleStripRearRight;
    private Float wheelInPuddleDepthFrontLeft;
    private Float wheelInPuddleDepthFrontRight;
    private Float wheelInPuddleDepthRearLeft;
    private Float wheelInPuddleDepthRearRight;
    private Float surfaceRumbleFrontLeft;
    private Float surfaceRumbleFrontRight;
    private Float surfaceRumbleRearLeft;
    private Float surfaceRumbleRearRight;
    private Float tireSlipAngleFrontLeft;
    private Float tireSlipAngleFrontRight;
    private Float tireSlipAngleRearLeft;
    private Float tireSlipAngleRearRight;
    private Float tireCombinedSlipFrontLeft;
    private Float tireCombinedSlipFrontRight;
    private Float tireCombinedSlipRearLeft;
    private Float tireCombinedSlipRearRight;
    private Float suspensionTravelMetersFrontLeft;
    private Float suspensionTravelMetersFrontRight;
    private Float suspensionTravelMetersRearLeft;
    private Float suspensionTravelMetersRearRight;
    private Integer carClass;
    private Integer carPerformanceIndex;
    private Integer drivetrainType;
    private Integer numCylinders;
    private Integer carType;
    private Byte unknown1;
    private Byte unknown2;
    private Byte unknown3;
    private Byte unknown4;
    private Byte unknown5;
    private Byte unknown6;
    private Byte unknown7;
    private Byte unknown8;
    private Integer carOrdinal;
    private Float positionX;
    private Float positionY;
    private Float positionZ;
    private Float speed;
    private Float power;
    private Float torque;
    private Float tireTempFrontLeft;
    private Float tireTempFrontRight;
    private Float tireTempRearLeft;
    private Float tireTempRearRight;
    private Float boost;
    private Float fuel;
    private Float distanceTraveled;
    private Float bestLap;
    private Float lastLap;
    private Float currentLap;
    private Float currentRaceTime;
    private Short lapNumber;
    private Byte racePosition;
    private Byte throttle;
    private Byte brake;
    private Byte clutch;
    private Byte handbrake;
    private Byte gear;
    private Byte steer;
    private Byte normalizedDrivingLine;
    private Byte normalizedAIBrakeDifference;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public ForzaApi(byte[] bytes) {
        readOK = false;
        if (bytes.length < PACKET_SIZE) {
            try {
                throw new Exception("Invalid len");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        df = new DecimalFormat("###.##");
        df.setRoundingMode(RoundingMode.DOWN);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        bb.order(ByteOrder.LITTLE_ENDIAN);

        try {
            isRaceOn = getFromBuffer(bb, int.class) == 1 ? true : false;
            timeStampMS = getFromBuffer(bb, long.class);
            engineMaxRpm = getFromBuffer(bb, float.class);
            engineIdleRpm = getFromBuffer(bb, float.class);
            currentEngineRpm = getFromBuffer(bb, float.class);
            accelerationX = getFromBuffer(bb, float.class);
            accelerationY = getFromBuffer(bb, float.class);
            accelerationZ = getFromBuffer(bb, float.class);
            velocityX = getFromBuffer(bb, float.class);
            velocityY = getFromBuffer(bb, float.class);
            velocityZ = getFromBuffer(bb, float.class);
            angularVelocityX = getFromBuffer(bb, float.class);
            angularVelocityY = getFromBuffer(bb, float.class);
            angularVelocityZ = getFromBuffer(bb, float.class);
            yaw = getFromBuffer(bb, float.class);
            pitch = getFromBuffer(bb, float.class);
            roll = getFromBuffer(bb, float.class);
            normalizedSuspensionTravelFrontLeft = getFromBuffer(bb, float.class);
            normalizedSuspensionTravelFrontRight = getFromBuffer(bb, float.class);
            normalizedSuspensionTravelRearLeft = getFromBuffer(bb, float.class);
            normalizedSuspensionTravelRearRight = getFromBuffer(bb, float.class);
            tireSlipRatioFrontLeft = getFromBuffer(bb, float.class);
            tireSlipRatioFrontRight = getFromBuffer(bb, float.class);
            tireSlipRatioRearLeft = getFromBuffer(bb, float.class);
            tireSlipRatioRearRight = getFromBuffer(bb, float.class);
            wheelRotationSpeedFrontLeft = getFromBuffer(bb, float.class);
            wheelRotationSpeedFrontRight = getFromBuffer(bb, float.class);
            wheelRotationSpeedRearLeft = getFromBuffer(bb, float.class);
            wheelRotationSpeedRearRight = getFromBuffer(bb, float.class);
            wheelOnRumbleStripFrontLeft = getFromBuffer(bb, int.class);
            wheelOnRumbleStripFrontRight = getFromBuffer(bb, int.class);
            wheelOnRumbleStripRearLeft = getFromBuffer(bb, int.class);
            wheelOnRumbleStripRearRight = getFromBuffer(bb, int.class);
            wheelInPuddleDepthFrontLeft = getFromBuffer(bb, float.class);
            wheelInPuddleDepthFrontRight = getFromBuffer(bb, float.class);
            wheelInPuddleDepthRearLeft = getFromBuffer(bb, float.class);
            wheelInPuddleDepthRearRight = getFromBuffer(bb, float.class);
            surfaceRumbleFrontLeft = getFromBuffer(bb, float.class);
            surfaceRumbleFrontRight = getFromBuffer(bb, float.class);
            surfaceRumbleRearLeft = getFromBuffer(bb, float.class);
            surfaceRumbleRearRight = getFromBuffer(bb, float.class);
            tireSlipAngleFrontLeft = getFromBuffer(bb, float.class);
            tireSlipAngleFrontRight = getFromBuffer(bb, float.class);
            tireSlipAngleRearLeft = getFromBuffer(bb, float.class);
            tireSlipAngleRearRight = getFromBuffer(bb, float.class);
            tireCombinedSlipFrontLeft = getFromBuffer(bb, float.class);
            tireCombinedSlipFrontRight = getFromBuffer(bb, float.class);
            tireCombinedSlipRearLeft = getFromBuffer(bb, float.class);
            tireCombinedSlipRearRight = getFromBuffer(bb, float.class);
            suspensionTravelMetersFrontLeft = getFromBuffer(bb, float.class);
            suspensionTravelMetersFrontRight = getFromBuffer(bb, float.class);
            suspensionTravelMetersRearLeft = getFromBuffer(bb, float.class);
            suspensionTravelMetersRearRight = getFromBuffer(bb, float.class);
            carOrdinal = getFromBuffer(bb, int.class);
            carClass = getFromBuffer(bb, int.class);
            carPerformanceIndex = getFromBuffer(bb, int.class);
            drivetrainType = getFromBuffer(bb, int.class);
            numCylinders = getFromBuffer(bb, int.class);
            carType = getFromBuffer(bb, int.class);
            unknown1 = getFromBuffer(bb, byte.class);
            unknown2 = getFromBuffer(bb, byte.class);
            unknown3 = getFromBuffer(bb, byte.class);
            unknown4 = getFromBuffer(bb, byte.class);
            unknown5 = getFromBuffer(bb, byte.class);
            unknown6 = getFromBuffer(bb, byte.class);
            unknown7 = getFromBuffer(bb, byte.class);
            unknown8 = getFromBuffer(bb, byte.class);
            positionX = getFromBuffer(bb, float.class);
            positionY = getFromBuffer(bb, float.class);
            positionZ = getFromBuffer(bb, float.class);
            speed = getFromBuffer(bb, float.class);
            power = getFromBuffer(bb, float.class);
            torque = getFromBuffer(bb, float.class);
            tireTempFrontLeft = getFromBuffer(bb, float.class);
            tireTempFrontRight = getFromBuffer(bb, float.class);
            tireTempRearLeft = getFromBuffer(bb, float.class);
            tireTempRearRight = getFromBuffer(bb, float.class);
            boost = getFromBuffer(bb, float.class);
            fuel = getFromBuffer(bb, float.class);
            distanceTraveled = getFromBuffer(bb, float.class);
            bestLap = getFromBuffer(bb, float.class);
            lastLap = getFromBuffer(bb, float.class);
            currentLap = getFromBuffer(bb, float.class);
            currentRaceTime = getFromBuffer(bb, float.class);
            lapNumber = getFromBuffer(bb, short.class);
            racePosition = getFromBuffer(bb, byte.class);
            throttle = getFromBuffer(bb, byte.class);
            brake = getFromBuffer(bb, byte.class);
            clutch = getFromBuffer(bb, byte.class);
            handbrake = getFromBuffer(bb, byte.class);
            gear = getFromBuffer(bb, byte.class);
            steer = getFromBuffer(bb, byte.class);
            normalizedDrivingLine = getFromBuffer(bb, byte.class);
            normalizedAIBrakeDifference = getFromBuffer(bb, byte.class);

            readOK = bb.position() == PACKET_SIZE;
        } catch (Exception e) {
            try {
                throw new Exception("Failed to parse Packet");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private static boolean checkBuffer(ByteBuffer buffer, int size) {
        return buffer.hasRemaining() && buffer.remaining() >= size;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressWarnings("unchecked")
    private static <T> T getFromBuffer(ByteBuffer buffer, Class<T> clazz) throws Exception {
        switch (clazz.getName()) {
            case "int":
                return (T) (checkBuffer(buffer, 4) ? (Object) buffer.getInt() : 0);
            case "long":
                return (T) (checkBuffer(buffer, 4) ? (Object) Integer.toUnsignedLong(buffer.getInt()) : 0L);
            case "byte":
                return (T) (checkBuffer(buffer, 1) ? (Object) buffer.get() : 0);
            case "float":
                return (T) (checkBuffer(buffer, 4) ? (Object) buffer.getFloat() : 0f);
            case "short":
                return (T) (checkBuffer(buffer, 2) ? (Object) buffer.getShort() : 0);
        }
        throw new Exception("Invalid Type");
    }

    public boolean getIsRaceOn() {
        return isRaceOn;
    }

    public Long getTimeStampMS() {
        return timeStampMS;
    }

    public Integer getEngineMaxRpm() {
        return Math.round(engineMaxRpm);
    }

    public Integer getEngineIdleRpm() {
        return Math.round(engineIdleRpm);
    }

    public Integer getCurrentEngineRpm() {
        return Math.round(currentEngineRpm);
    }

    public Integer getAccelerationX() {
       return Math.round((accelerationX*100f));
    }

    public int getAccelerationY() {
        return Math.round(accelerationY*100f);
    }

    public Integer getAccelerationZ() {
        return Math.round(accelerationZ*100f);
    }

    public int getVelocityX() {
        return Math.round(velocityX*100f);
    }

    public Integer getVelocityY() {
        return Math.round(velocityY*100f);
    }

    public Integer getVelocityZ() {
        return Math.round(velocityZ*100f);
    }

    public Integer getAngularVelocityX() {
       return Math.round(angularVelocityX*100f);
    }

    public Integer getAngularVelocityY() {
        return Math.round(angularVelocityY*100f);
    }

    public Integer getAngularVelocityZ() {
        return Math.round(angularVelocityZ*100f);
    }

    public Integer getYaw() {
        return Math.round(yaw*100f);
    }

    public Integer getPitch() {
        return Math.round(pitch*100f);
    }

    public Integer getRoll() {
        return Math.round(roll*100f);
    }

    public Integer getNormalizedSuspensionTravelFrontLeft() {
        return Math.round(normalizedSuspensionTravelFrontLeft*100f);

    }

    public Integer getNormalizedSuspensionTravelFrontRight() {
        return Math.round(normalizedSuspensionTravelFrontRight*100f);
    }

    public Integer getNormalizedSuspensionTravelRearLeft() {
        return Math.round(normalizedSuspensionTravelRearLeft*100f);
    }

    public Integer getNormalizedSuspensionTravelRearRight() {
        return Math.round(normalizedSuspensionTravelRearRight*100f);
    }

    public Integer getTireSlipRatioFrontLeft() {
        return Math.round(tireSlipRatioFrontLeft*100f);
    }

    public Integer getTireSlipRatioFrontRight() {
        return Math.round(tireSlipRatioFrontRight*100f);
    }

    public Integer getTireSlipRatioRearLeft() {
        return Math.round(tireSlipRatioRearLeft*100f);
    }

    public Integer getTireSlipRatioRearRight() {
        return Math.round(tireSlipRatioRearRight*100f);
    }

    public Integer getWheelRotationSpeedFrontLeft() {
        return Math.round(wheelRotationSpeedFrontLeft*100f);
    }

    public Integer getWheelRotationSpeedFrontRight() {
        return Math.round(wheelRotationSpeedFrontRight*100f);
    }

    public Integer getWheelRotationSpeedRearLeft() {
        return Math.round(wheelRotationSpeedRearLeft*100f);
    }

    public Integer getWheelRotationSpeedRearRight() {
        return Math.round(wheelRotationSpeedRearRight*100f);
    }

    public Integer getWheelOnRumbleStripFrontLeft() {
        return wheelOnRumbleStripFrontLeft;
    }

    public Integer getWheelOnRumbleStripFrontRight() {
        return wheelOnRumbleStripFrontRight;
    }

    public Integer getWheelOnRumbleStripRearLeft() {
        return wheelOnRumbleStripRearLeft;
    }

    public Integer getWheelOnRumbleStripRearRight() {
        return wheelOnRumbleStripRearRight;
    }

    public Float getWheelInPuddleDepthFrontLeft() {
        return wheelInPuddleDepthFrontLeft;
    }

    public Float getWheelInPuddleDepthFrontRight() {
        return wheelInPuddleDepthFrontRight;
    }

    public Float getWheelInPuddleDepthRearLeft() {
        return wheelInPuddleDepthRearLeft;
    }

    public Float getWheelInPuddleDepthRearRight() {
        return wheelInPuddleDepthRearRight;
    }

    public Float getSurfaceRumbleFrontLeft() {
        return surfaceRumbleFrontLeft;
    }

    public Float getSurfaceRumbleFrontRight() {
        return surfaceRumbleFrontRight;
    }

    public Float getSurfaceRumbleRearLeft() {
        return surfaceRumbleRearLeft;
    }

    public Float getSurfaceRumbleRearRight() {
        return surfaceRumbleRearRight;
    }

    public Integer getTireSlipAngleFrontLeft() {
        return Math.round(tireSlipAngleFrontLeft*100f);
    }

    public Integer getTireSlipAngleFrontRight() {
        return Math.round(tireSlipAngleFrontRight*100f);
    }

    public Integer getTireSlipAngleRearLeft() {
        return Math.round(tireSlipAngleRearLeft*100f);
    }

    public Integer getTireSlipAngleRearRight() {
        return Math.round(tireSlipAngleRearRight*100f);
    }

    public Integer getTireCombinedSlipFrontLeft() {
        return Math.round(tireCombinedSlipFrontLeft*100f);
    }

    public Integer getTireCombinedSlipFrontRight() {
        return Math.round(tireCombinedSlipFrontRight*100f);
    }

    public Integer getTireCombinedSlipRearLeft() {
        return Math.round(tireCombinedSlipRearLeft*100f);
    }

    public Integer getTireCombinedSlipRearRight() {
        return Math.round(tireCombinedSlipRearRight*100f);
    }

    public Integer getSuspensionTravelMetersFrontLeft() {
        return Math.round(suspensionTravelMetersFrontLeft*100f);
    }

    public Integer getSuspensionTravelMetersFrontRight() {
        return Math.round(suspensionTravelMetersFrontRight*100f);
    }

    public Integer getSuspensionTravelMetersRearLeft() {
        return Math.round(suspensionTravelMetersRearLeft*100f);
    }

    public Integer getSuspensionTravelMetersRearRight() {
        return Math.round(suspensionTravelMetersRearRight*100f);
    }

    public String getCarClass() {
        switch (carClass) {
            case 0:
                return "D";
            case 1:
                return "C";
            case 2:
                return "B";
            case 3:
                return "A";
            case 4:
                return "S1";
            case 5:
                return "S2";
            case 6:
                return "X";
        }
        return "-";
    }

    public Integer getCarPerformanceIndex() {
        return carPerformanceIndex;
    }

    public String getDrivetrain() {
        switch(drivetrainType){
            case 0:
                return "FWD";
            case 1:
                return "RWD";
            case 2:
                return "AWD";
            default:
                return "-";
        }
    }

    public Integer getNumCylinders() {
        return numCylinders;
    }

    public String getCarType() {
        switch (carType) {
            case 11:
                return "Modern Super Cars";
            case 12:
                return "Retro Super Cars";
            case 13:
                return "Hyper Cars";
            case 14:
                return "Retro Saloons";
            case 16:
                return "Vans & Utility";
            case 17:
                return "Retro Sports Cars";
            case 18:
                return "Modern Sports Cars";
            case 19:
                return "Super Saloons";
            case 20:
                return "Classic Racers";
            case 21:
                return "Cult Cars";
            case 22:
                return "Rare Classics";
            case 25:
                return "Super Hot Hatch";
            case 29:
                return "Rods & Customs";
            case 30:
                return "Retro Muscle";
            case 31:
                return "Modern Muscle";
            case 32:
                return "Retro Rally";
            case 33:
                return "Classic Rally";
            case 34:
                return "Rally Monsters";
            case 35:
                return "Modern Rally";
            case 36:
                return "GT Cars";
            case 37:
                return "Super GT";
            case 38:
                return "Extreme Offroad";
            case 39:
                return "Sports Utility Heroes";
            case 40:
                return "Offroad";
            case 41:
                return "Offroad Buggies";
            case 42:
                return "Classic Sports Cars";
            case 43:
                return "Track Toys";
            case 44:
                return "Vintage Racers";
            case 45:
                return "Trucks";
            default:
                return "Unknown (" + carType + ")";
        }
    }

    public Byte getUnknown1() {
        return unknown1;
    }

    public Byte getUnknown2() {
        return unknown2;
    }

    public Byte getUnknown3() {
        return unknown3;
    }

    public Byte getUnknown4() {
        return unknown4;
    }

    public Byte getUnknown5() {
        return unknown5;
    }

    public Byte getUnknown6() {
        return unknown6;
    }

    public Byte getUnknown7() {
        return unknown7;
    }

    public Byte getUnknown8() {
        return unknown8;
    }

    public Integer getCarOrdinal() {
        return carOrdinal;
    }

    public int getPositionX() {
        return Math.round(positionX*100f);
    }

    public Integer getPositionY() {
        return Math.round(positionY*100f);
    }

    public Integer getPositionZ() {
        return Math.round(positionZ*100f);
    }

    public Integer getSpeedMps() {
        return Math.round(speed);
    }

    public Integer getSpeedKph() {
        float f = getSpeedMps() * 3.6f;
        return Math.round(f);
    }

    public Integer getSpeedMph() {
        float f = getSpeedMps() * 2.23694f;
        return Math.round(f);
    }

    public Integer getPower() {
        return Math.round(power);
    }

    public Integer getHorsePower() {
        float f = getPower() * 0.00134102f;
        return Math.round(f);
    }

    public Integer getTorque() {
        return Math.round(torque);
    }

    public Integer getTireTempFrontLeft() {
       return Math.round(tireTempFrontLeft);
    }

    public Integer getTireTempFrontRight() {
        return Math.round(tireTempFrontRight);
    }

    public Integer getTireTempRearLeft() {
        return Math.round(tireTempRearLeft);
    }

    public Integer getTireTempRearRight() {
        return Math.round(tireTempRearRight);
    }

    public Integer getBoost() {
        return Math.round(boost);
    }

    public Float getFuel() {
        return fuel;
    }

    public Float getDistanceTraveled() {
        return distanceTraveled;
    }

    public Float getBestLap() {
        return bestLap;
    }

    public Float getLastLap() {
        return lastLap;
    }

    public Float getCurrentLap() {
        return currentLap;
    }

    public Float getCurrentRaceTime() {
        return currentRaceTime;
    }

    public Short getLapNumber() {
        return lapNumber;
    }

    public Byte getRacePosition() {
        return racePosition;
    }

    public Integer getThrottle() {
        return throttle & 0xff;
    }

    public Integer getBrake() {
        return brake & 0xff;
    }

    public Integer getClutch() {
        return clutch & 0xff;
    }

    public Integer getHandbrake() {
        return handbrake & 0xff;
    }

    public Integer getGear() {
        return gear & 0xff;
    }

    public Integer getSteer() {
        return steer & 0xff;
    }

    public Integer getNormalizedDrivingLine() {
        return normalizedDrivingLine & 0xff;
    }

    public Integer getNormalizedAIBrakeDifference() {
        return normalizedAIBrakeDifference & 0xff;
    }


    public boolean ReadOK() {
        return readOK;
    }

    public Integer getAverageVelocity() {
        return Math.round(getVector3DLength(getVelocityX(), getVelocityY(), getVelocityZ()));

    }

    public Integer getTireTempAverageFront() {
        return Math.round(getAverage(getTireTempFrontLeft(), getTireTempFrontRight()));
    }

    public Integer getTireTempAverageRear() {
        return Math.round(getAverage(getTireTempRearLeft(), getTireTempRearRight()));

    }

    private Float getAverage(float valueOne, float valueTwo, float valueThree, float valueFour) {
        return (valueOne + valueTwo + valueThree + valueFour) / 4f;
    }

    public Integer getTireTempAverageLeft() {
        return Math.round(getAverage(
                getTireTempFrontLeft(),
                getTireTempRearLeft()
        ));
    }

    public Integer getTireTempAverageRight() {
        return Math.round(getAverage(getTireTempFrontRight(), getTireTempRearRight()));
    }

    public Integer getTireTempAverageTotal() {
        return Math.round(getAverage(
                getTireTempFrontLeft(),
                getTireTempFrontRight(),
                getTireTempRearLeft(),
                getTireTempRearRight()
        ));
    }

    private float getAverage(float valueOne, float valueTwo) {
        return (valueOne + valueTwo) / 2f;
    }

    private float getVector3DLength(float x, float y, float z) {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "{" +
                " isRaceOn='" + getIsRaceOn() + "'" +
                ", timeStampMS='" + getTimeStampMS() + "'" +
                ", engineMaxRpm='" + getEngineMaxRpm() + "'" +
                ", engineIdleRpm='" + getEngineIdleRpm() + "'" +
                ", currentEngineRpm='" + getCurrentEngineRpm() + "'" +
                ", accelerationX='" + getAccelerationX() + "'" +
                ", accelerationY='" + getAccelerationY() + "'" +
                ", accelerationZ='" + getAccelerationZ() + "'" +
                ", velocityX='" + getVelocityX() + "'" +
                ", velocityY='" + getVelocityY() + "'" +
                ", velocityZ='" + getVelocityZ() + "'" +
                ", averageVelocityZ='" + getAverageVelocity() + "'" +
                ", angularVelocityX='" + getAngularVelocityX() + "'" +
                ", angularVelocityY='" + getAngularVelocityY() + "'" +
                ", angularVelocityZ='" + getAngularVelocityZ() + "'" +
                ", yaw='" + getYaw() + "'" +
                ", pitch='" + getPitch() + "'" +
                ", roll='" + getRoll() + "'" +
                ", normalizedSuspensionTravelFrontLeft='" + getNormalizedSuspensionTravelFrontLeft() + "'" +
                ", normalizedSuspensionTravelFrontRight='" + getNormalizedSuspensionTravelFrontRight() + "'" +
                ", normalizedSuspensionTravelRearLeft='" + getNormalizedSuspensionTravelRearLeft() + "'" +
                ", normalizedSuspensionTravelRearRight='" + getNormalizedSuspensionTravelRearRight() + "'" +
                ", tireSlipRatioFrontLeft='" + getTireSlipRatioFrontLeft() + "'" +
                ", tireSlipRatioFrontRight='" + getTireSlipRatioFrontRight() + "'" +
                ", tireSlipRatioRearLeft='" + getTireSlipRatioRearLeft() + "'" +
                ", tireSlipRatioRearRight='" + getTireSlipRatioRearRight() + "'" +
                ", wheelRotationSpeedFrontLeft='" + getWheelRotationSpeedFrontLeft() + "'" +
                ", wheelRotationSpeedFrontRight='" + getWheelRotationSpeedFrontRight() + "'" +
                ", wheelRotationSpeedRearLeft='" + getWheelRotationSpeedRearLeft() + "'" +
                ", wheelRotationSpeedRearRight='" + getWheelRotationSpeedRearRight() + "'" +
                ", wheelOnRumbleStripFrontLeft='" + getWheelOnRumbleStripFrontLeft() + "'" +
                ", wheelOnRumbleStripFrontRight='" + getWheelOnRumbleStripFrontRight() + "'" +
                ", wheelOnRumbleStripRearLeft='" + getWheelOnRumbleStripRearLeft() + "'" +
                ", wheelOnRumbleStripRearRight='" + getWheelOnRumbleStripRearRight() + "'" +
                ", wheelInPuddleDepthFrontLeft='" + getWheelInPuddleDepthFrontLeft() + "'" +
                ", wheelInPuddleDepthFrontRight='" + getWheelInPuddleDepthFrontRight() + "'" +
                ", wheelInPuddleDepthRearLeft='" + getWheelInPuddleDepthRearLeft() + "'" +
                ", wheelInPuddleDepthRearRight='" + getWheelInPuddleDepthRearRight() + "'" +
                ", surfaceRumbleFrontLeft='" + getSurfaceRumbleFrontLeft() + "'" +
                ", surfaceRumbleFrontRight='" + getSurfaceRumbleFrontRight() + "'" +
                ", surfaceRumbleRearLeft='" + getSurfaceRumbleRearLeft() + "'" +
                ", surfaceRumbleRearRight='" + getSurfaceRumbleRearRight() + "'" +
                ", tireSlipAngleFrontLeft='" + getTireSlipAngleFrontLeft() + "'" +
                ", tireSlipAngleFrontRight='" + getTireSlipAngleFrontRight() + "'" +
                ", tireSlipAngleRearLeft='" + getTireSlipAngleRearLeft() + "'" +
                ", tireSlipAngleRearRight='" + getTireSlipAngleRearRight() + "'" +
                ", tireCombinedSlipFrontLeft='" + getTireCombinedSlipFrontLeft() + "'" +
                ", tireCombinedSlipFrontRight='" + getTireCombinedSlipFrontRight() + "'" +
                ", tireCombinedSlipRearLeft='" + getTireCombinedSlipRearLeft() + "'" +
                ", tireCombinedSlipRearRight='" + getTireCombinedSlipRearRight() + "'" +
                ", suspensionTravelMetersFrontLeft='" + getSuspensionTravelMetersFrontLeft() + "'" +
                ", suspensionTravelMetersFrontRight='" + getSuspensionTravelMetersFrontRight() + "'" +
                ", suspensionTravelMetersRearLeft='" + getSuspensionTravelMetersRearLeft() + "'" +
                ", suspensionTravelMetersRearRight='" + getSuspensionTravelMetersRearRight() + "'" +
                ", carClass='" + getCarClass() + "'" +
                ", carPerformanceIndex='" + getCarPerformanceIndex() + "'" +
                ", drivetrainType='" + getDrivetrain() + "'" +
                ", numCylinders='" + getNumCylinders() + "'" +
                ", carType='" + getCarType() + "'" +
                ", unknown1='" + getUnknown1() + "'" +
                ", unknown2='" + getUnknown2() + "'" +
                ", unknown3='" + getUnknown3() + "'" +
                ", unknown4='" + getUnknown4() + "'" +
                ", unknown5='" + getUnknown5() + "'" +
                ", unknown6='" + getUnknown6() + "'" +
                ", unknown7='" + getUnknown7() + "'" +
                ", unknown8='" + getUnknown8() + "'" +
                ", carOrdinal='" + getCarOrdinal() + "'" +
                ", positionX='" + getPositionX() + "'" +
                ", positionY='" + getPositionY() + "'" +
                ", positionZ='" + getPositionZ() + "'" +
                ", speedMps='" + getSpeedMps() + "'" +
                ", speedMph='" + getSpeedMph() + "'" +
                ", speedKph='" + getSpeedKph() + "'" +
                ", power='" + getPower() + "'" +
                ", horsepower='" + getHorsePower() + "'" +
                ", torque='" + getTorque() + "'" +
                ", tireTempFrontLeft='" + getTireTempFrontLeft() + "'" +
                ", tireTempFrontRight='" + getTireTempFrontRight() + "'" +
                ", tireTempRearLeft='" + getTireTempRearLeft() + "'" +
                ", tireTempRearRight='" + getTireTempRearRight() + "'" +
                ", boost='" + getBoost() + "'" +
                ", fuel='" + getFuel() + "'" +
                ", distanceTraveled='" + getDistanceTraveled() + "'" +
                ", bestLap='" + getBestLap() + "'" +
                ", lastLap='" + getLastLap() + "'" +
                ", currentLap='" + getCurrentLap() + "'" +
                ", currentRaceTime='" + getCurrentRaceTime() + "'" +
                ", lapNumber='" + getLapNumber() + "'" +
                ", racePosition='" + getRacePosition() + "'" +
                ", accel='" + getThrottle() + "'" +
                ", brake='" + getBrake() + "'" +
                ", clutch='" + getClutch() + "'" +
                ", handbrake='" + getHandbrake() + "'" +
                ", gear='" + getGear() + "'" +
                ", steer='" + getSteer() + "'" +
                ", normalizedDrivingLine='" + getNormalizedDrivingLine() + "'" +
                ", normalizedAIBrakeDifference='" + getNormalizedAIBrakeDifference() + "'" +
                "}";
    }
}