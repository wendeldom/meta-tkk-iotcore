SUMMARY = "Packagegroup for iotcore tools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
            packagegroup-tkk-iotcore-tools           \
            packagegroup-tkk-iotcore-tools-core      \
            packagegroup-tkk-iotcore-tools-kernel    \
            packagegroup-tkk-iotcore-tools-network   \
            "

# Manage to provide all framework tools base packages with overall one
RDEPENDS:packagegroup-tkk-iotcore-tools = "\
    packagegroup-tkk-iotcore-tools-core      \
    packagegroup-tkk-iotcore-tools-kernel    \
    packagegroup-tkk-iotcore-tools-network   \
    "

SUMMARY:packagegroup-tkk-iotcore-tools-core = "Framework tools base components for core"
RDEPENDS:packagegroup-tkk-iotcore-tools-core = "\
    ckermit         \
    ntp             \
    coreutils       \
    libiio-iiod     \
    libiio-tests    \
    lrzsz           \
    libgpiod        \
    libgpiod-tools  \
    openssl-engines \
    ${@bb.utils.contains('DISTRO_FEATURES', 'usbgadget', 'usbotg-gadget-config', '', d)} \
    "

SUMMARY:packagegroup-tkk-iotcore-tools-kernel = "Framework tools base components for kernel"
RDEPENDS:packagegroup-tkk-iotcore-tools-kernel = "\
    can-utils       \
    i2c-tools       \
    strace          \
    usbutils        \
    \
    evtest          \
    memtester       \
    mtd-utils       \
    v4l-utils       \
    media-ctl       \
    util-linux      \
    util-linux-fdisk\
    pciutils        \
    "

SUMMARY:packagegroup-tkk-iotcore-tools-network = "Framework tools base components for network"
RDEPENDS:packagegroup-tkk-iotcore-tools-network = "\
    ethtool         \
    iproute2        \
    curl            \
    "