SUMMARY = "Packagegroup for iotcore base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
            packagegroup-tkk-iotcore-base            \
            packagegroup-tkk-iotcore-base-fs         \
            "

# Manage to provide all framework core base packages with overall one
RDEPENDS:packagegroup-tkk-iotcore-base = "\
    packagegroup-tkk-iotcore-base-fs         \
    "

SUMMARY:packagegroup-tkk-iotcore-base-fs = "Framework core base components for filesystem"
RDEPENDS:packagegroup-tkk-iotcore-base-fs = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-mount-partitions', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'userfs-cleanup-package', '', d)} \
    "
