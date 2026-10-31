SUMMARY = "TKK IoT Gateway"
LICENSE = "AGPL-3.0-only & LGPL-3.0-only & MIT & BSL-1.0"
LIC_FILES_CHKSUM = "\
file://LICENSE;md5=4ae09d45eac4aa08d013b5f2e01c67f6 \
file://external/snap7micro/lgpl-3.0.txt;md5=38138baa100d7259934590850bc0406e \
file://external/nlohmann/LICENSE.MIT;md5=e046aa7fd39db177f5ca0cefe06ddbdc \
file://external/utfcpp/LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c \
file://external/sqlitecpp/LICENSE.txt;md5=0840de529036310430d7c91443e81e38 \
"

inherit cmake systemd

DEPENDS += "sqlite3"
RDEPENDS:${PN} += "libsqlite3"

SRC_URI = "git:///workspace/tkk-iotgateway-app;protocol=file;branch=feat/data_sink"
SRCREV = "4b9582df49dcf6a28f971536ef531c4db82116a4"
PV = "0.1.0+git"
S = "${WORKDIR}/git"


EXTRA_OECMAKE = "-DTKK_BUILD_TESTS=OFF -DTKK_CONFIG_DIR=/etc/tkk-iotgateway"

SRC_URI += "file://tkk-iotgateway.service"

SYSTEMD_SERVICE:${PN} = "tkk-iotgateway.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/tkk-iotgateway.service ${D}${systemd_system_unitdir}/

    install -d ${D}${sysconfdir}/tkk-iotgateway/s7
    install -d ${D}${sysconfdir}/tkk-iotgateway/opcua
}