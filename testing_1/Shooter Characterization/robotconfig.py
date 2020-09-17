{
    # Unit of analysis
    # Options:
    # 'Degrees'
    # 'Radians'
    # 'Rotations'
    "units": "Rotations",
    # Class names of motor controllers used.
    # Options:
    # 'Spark'
    # 'Victor'
    # 'VictorSP'
    # 'PWMTalonSRX'
    # 'PWMVictorSPX'
    # 'WPI_TalonSRX'
    # 'WPI_VictorSPX'
    # If you only have 1 motor all the below arrays should only have one element
    "controllerTypes": ["WPI_TalonSRX", "WPI_TalonSRX"],
    # Ports for the flywheel motor(s)
    # The first port is the one with the encoder attached
    "motorPorts": [7, 8],
    # Inversions for the left-flywheel motor(s)
    "motorsInverted": [False, True],
    # Encoder edges-per-revolution (*NOT* cycles per revolution!)
    # This value should be the edges per revolution *of the flywheel*, and so
    # should take into account gearing between the encoder and the wheels
    #note : I did not take into account of gear ratio
    "encoderEPR": 1024,
    # Ports for the flywheel encoder
    "encoderPorts": [5, 6],
    # Whether the encoder is inverted
    "encoderInverted": False,
}

